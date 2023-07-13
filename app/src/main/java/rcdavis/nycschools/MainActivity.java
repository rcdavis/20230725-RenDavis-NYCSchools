package rcdavis.nycschools;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import rcdavis.nycschools.databinding.ActivityMainBinding;
import rcdavis.nycschools.school.Address;
import rcdavis.nycschools.school.SATScores;
import rcdavis.nycschools.util.MockData;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Address address = MockData.getAddress();
        final SATScores satScores = MockData.getSATScores();

        Log.d("NYCS", address.toString());
        Log.d("NYCS", satScores.toString());
    }
}
