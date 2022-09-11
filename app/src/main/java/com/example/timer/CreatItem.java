package com.example.timer;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Button;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;
import java.util.Calendar;

public class CreatItem extends AppCompatActivity {
    private ScrollView scrollView;
    private DatePicker datePicker;
    private EditText editTextDate;
    private EditText editTextWork;
    private Button buttonDate;
    private TimePicker timePicker;
    private TextView textViewTime;
    private Calendar calendar = Calendar.getInstance();
    private int year = calendar.get(Calendar.YEAR);
    private int month  = calendar.get(Calendar.MONTH);
    private int day = calendar.get(Calendar.DAY_OF_MONTH);
    private int hour = calendar.get(Calendar.HOUR);
    private int minute = calendar.get(Calendar.MINUTE);

    // Change this value and run the application again.
    private boolean is24HView = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_item);
        calendar.setTimeInMillis(System.currentTimeMillis());
        this.scrollView = (ScrollView) this.findViewById(R.id.scrollView);
        this.editTextDate = (EditText) this.findViewById(R.id.editText_date);
        this.buttonDate = (Button) this.findViewById(R.id.button_date);
        this.datePicker = (DatePicker) this.findViewById(R.id.datePicker);
        this.editTextWork = (EditText) this.findViewById(R.id.editTextWork);
        this.textViewTime = (TextView) this.findViewById(R.id.textView_time);
        this.timePicker = (TimePicker) this.findViewById(R.id.timePicker);
        this.timePicker.setIs24HourView(this.is24HView);
        this.timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timePickerChange(view,hourOfDay, minute );
            }
        });

        this.datePicker.init( year, month , day , new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                datePickerChange(  datePicker,   year,   month,   dayOfMonth);
            }
        });

        this.buttonDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                showDate();
            }
        });
    }
    private void timePickerChange(TimePicker view, int hourOfDay, int minute) {
        this.textViewTime.setText(hourOfDay + ":" + minute);
    }
    private void datePickerChange(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
        Log.d("test", String.valueOf(this.hour));
        this.editTextDate.setText(dayOfMonth +"-" + (month + 1) + "-" + year);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showDate()  {
        int year = this.datePicker.getYear();
        int month = this.datePicker.getMonth(); // 0 - 11
        int day = this.datePicker.getDayOfMonth();
        int hourOfDay = this.timePicker.getHour();
        int minute = this.timePicker.getMinute();
        String textWork = String.valueOf(this.editTextWork.getText());
        Toast.makeText(this, "Date: " + day+"-"+ (month + 1) +"-"+ year, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(CreatItem.this, ListItem.class);
        intent.putExtra("Key_1", "Work: " + textWork+" "+"Date: " + day+"-"+ (month + 1) +"-"+ year + " "+"Time: " + hourOfDay + ":" + minute);
        startActivity(intent);
    }

}



