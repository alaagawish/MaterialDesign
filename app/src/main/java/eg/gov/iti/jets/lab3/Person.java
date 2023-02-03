package eg.gov.iti.jets.lab3;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Person implements Parcelable {
    String firstName;
    String lastName;
    List<String> languages;
    String gender;

    public Person() {
        languages = new ArrayList<>();
    }

    public Person(String firstName, String lastName, List<String> languages, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.languages = languages;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeStringList(this.languages);
        dest.writeString(this.gender);
    }

    public void readFromParcel(Parcel source) {
        this.firstName = source.readString();
        this.lastName = source.readString();
        this.languages = source.createStringArrayList();
        this.gender = source.readString();
    }

    protected Person(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.languages = in.createStringArrayList();
        this.gender = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
