package eg.gov.iti.jets.lab3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.jets.lab3.FirstFragmentDirections;
import eg.gov.iti.jets.lab3.FirstFragmentDirections.ActionFirstFragmentToSecondFragment;

public class FirstFragment extends Fragment {
    MaterialButton enter;
    EditText firstNameEditText, secondNameEditText;
    RadioGroup radioGroup;
    String gender = null;
    Person person;
    CheckBox cBox, cppBox, javaBox;
    List<String> languages;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        enter = view.findViewById(R.id.enterButton);
        person = new Person();
        languages = new ArrayList<>();
        firstNameEditText = view.findViewById(R.id.firstNameEditText);
        secondNameEditText = view.findViewById(R.id.secondNameEditText);
        cppBox = view.findViewById(R.id.cppCheckBox);
        cBox = view.findViewById(R.id.cCheckBox);
        javaBox = view.findViewById(R.id.javaCheckBox);
        radioGroup = view.findViewById(R.id.radioGroup);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = view.findViewById(i);
                gender = radioButton.getText().toString();
                person.setGender(gender);
            }
        });

        enter.setOnClickListener(e -> {
//            Navigation.findNavController(e).navigate(R.id.action_firstFragment_to_secondFragment);
            if (gender == null || firstNameEditText.getText().length() < 1 || secondNameEditText.getText().length() < 1) {

                Toast.makeText(getContext(), "You have to complete all data...", Toast.LENGTH_SHORT).show();
            } else {
                if (cBox.isChecked()) {
                    languages.add(cBox.getText().toString());
                }
                if (cppBox.isChecked()) {
                    languages.add(cppBox.getText().toString());
                }
                if (javaBox.isChecked()) {
                    languages.add(javaBox.getText().toString());
                }
                person.setLanguages(languages);
                person.setFirstName(firstNameEditText.getText().toString());
                person.setLastName(secondNameEditText.getText().toString());
                ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(person);

                Navigation.findNavController(e).navigate(action);
            }

        });

    }
}