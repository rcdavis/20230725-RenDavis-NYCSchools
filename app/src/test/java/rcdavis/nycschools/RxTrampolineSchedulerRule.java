package rcdavis.nycschools;

import androidx.annotation.NonNull;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Helps with overriding schedulers for RxJava testing.
 * <a href="https://www.ericthecoder.com/2019/09/16/unit-testing-android-with-rxjava-and-retrofit/">Info Source</a>
 */
public class RxTrampolineSchedulerRule implements TestRule {
    private final Function<Scheduler, Scheduler> trampolineScheduler =
            scheduler -> Schedulers.trampoline();

    @NonNull
    @Override
    public Statement apply(@NonNull Statement base, @NonNull Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                RxJavaPlugins.reset();
                RxJavaPlugins.setIoSchedulerHandler(trampolineScheduler);
                RxJavaPlugins.setComputationSchedulerHandler(trampolineScheduler);
                RxJavaPlugins.setNewThreadSchedulerHandler(trampolineScheduler);

                RxAndroidPlugins.reset();
                RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                        schedulerCallable -> Schedulers.trampoline());

                base.evaluate();

                RxJavaPlugins.reset();
                RxAndroidPlugins.reset();
            }
        };
    }
}
