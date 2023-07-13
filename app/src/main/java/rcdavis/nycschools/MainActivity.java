package rcdavis.nycschools;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import rcdavis.nycschools.databinding.ActivityMainBinding;
import rcdavis.nycschools.school.School;
import rcdavis.nycschools.school.SchoolRepository;

public class MainActivity extends AppCompatActivity {
    private final CompositeDisposable mDisposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SchoolRepository schoolRepository = new SchoolRepository();
        mDisposables.add(schoolRepository.getAllSchools().subscribe(schools -> {
            for (final School school : schools) {
                Log.d("NYCS", school.toString());
            }
        }));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDisposables.dispose();
    }
}
