package eg.gov.iti.jets.lab3;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SecondFragment extends Fragment {
    LottieAnimationView lottieAnimationView;
    TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lottieAnimationView = view.findViewById(R.id.lottieLogo);
        text = view.findViewById(R.id.text);
        Person person = SecondFragmentArgs.fromBundle(getArguments()).getPerson();
        text.setText("Hello " + person.getFirstName() + " " + person.getLastName() + "\n");
        if (person.getGender().equals("Male")) {
            text.append("you are a good man.\n");
        } else {
            text.append("you are a good woman.\n");

        }
        if (person.getLanguages().size() > 0) {
            text.append("Because u prefer languages like: ");
            for (String l : person.getLanguages())
                text.append(l + " ");

        }

    }
}