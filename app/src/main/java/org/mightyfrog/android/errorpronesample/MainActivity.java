package org.mightyfrog.android.errorpronesample;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

/**
 * http://errorprone.info/
 * https://github.com/google/error-prone
 * https://github.com/tbroyer/gradle-errorprone-plugin
 *
 * @author Shigehiro Soejima
 */
public class MainActivity extends AppCompatActivity implements Parcelable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void main(String[] args) {
        Set<Short> s = new HashSet<>();
        for (short i = 0; i < 100; i++) {
            s.add(i);
            s.remove(i - 1);
        }
        System.out.println(s.size());
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public MainActivity() {
    }

    protected MainActivity(Parcel in) {
    }

    // @Override commented out to demonstrate error-prone
    public static final Parcelable.Creator<MainActivity> CREATOR = new Parcelable.Creator<MainActivity>() {
//        @Override
        public MainActivity createFromParcel(Parcel source) {
            return new MainActivity(source);
        }

//        @Override
        public MainActivity[] newArray(int size) {
            return new MainActivity[size];
        }
    };
}
