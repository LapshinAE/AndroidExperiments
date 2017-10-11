package com.example.sdk.activities;

import android.content.Context;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.sdk.R;
import com.example.sdk.databinding.ActivityMainBinding;
import com.example.sdk.sys.BaseViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel vm = new MainViewModel(this);
        ActivityMainBinding binding = ActivityMainBinding.bind(findViewById(R.id.root));
        binding.setVm(vm);
    }

    public static class MainViewModel extends BaseViewModel {

        private Context context;

        public ObservableField<String> text = new ObservableField<>();

        public MainViewModel(Context context) {
            this.context = context;
        }

        public void onClick() {
            Toast.makeText(context, "Click " + text.get(), Toast.LENGTH_SHORT).show();
        }
    }
}
