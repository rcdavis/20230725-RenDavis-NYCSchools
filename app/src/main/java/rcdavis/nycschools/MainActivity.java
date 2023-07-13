package rcdavis.nycschools;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import rcdavis.nycschools.databinding.ActivityMainBinding;
import rcdavis.nycschools.school.School;
import rcdavis.nycschools.util.MockData;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final List<School> schools = MockData.getSchools();

        for (final School school : schools) {
            Log.d("NYCS", school.toString());
        }
    }
}
