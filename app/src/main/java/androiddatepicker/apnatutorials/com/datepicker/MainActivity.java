package androiddatepicker.apnatutorials.com.datepicker ;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvToDate, tvFromDate;
    DateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
    int callerId = -1;
    //  public static final String DATE_FORMAT = "yyyy/MM/dd";
    public static final String DATE_FORMAT = "EEE, MMM d, yyyy";

    private Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvToDate = (TextView) findViewById(R.id.tvToDate);
        tvToDate.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvToDate:
                TextView et = (TextView) view;
                showDatePickerDialog(view.getId(), et.getText().toString().trim());
                break;

        }
    }

    /**
     * Method used to show date picker dialog
     *
     * @param callerId
     * @param dateText
     */
    public void showDatePickerDialog(int callerId, String dateText) {
        this.callerId = callerId;
        Date date = null;

        try {
            if (dateText.equals(""))
                date = new Date();
            else
                date = dateFormatter.parse(dateText);
        } catch (Exception exp) {
            // In case of expense initializa date with new Date
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // calendar month 0-11
        int day = calendar.get(Calendar.DATE);
        // date picker initialization
        DatePickerDialog datePicker = new DatePickerDialog(ctx, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                handleOnDateSet(year, month, day);
            }
        }, year, month, day);
        datePicker.setTitle("My date picker");
        datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ok", datePicker);
        datePicker.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Cancel button clicked
            }
        });
        datePicker.show();
    }

    /**
     * Method called when user select a date on date picker dialog
     *
     * @param year
     * @param month
     * @param day
     */
    public void handleOnDateSet(int year, int month, int day) {
        Date date = new GregorianCalendar(year, month, day).getTime();
        String formatedDate = dateFormatter.format(date);

        switch (callerId) {
            case R.id.tvToDate:
                tvToDate.setText(formatedDate);
                break;

        }
    }
    import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
    public class MainActivity extends ActionBarActivity {
        private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond;
        private TextView tvEvent;
        private Handler handler;
        private Runnable runnable;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            txtTimerDay = (TextView) findViewById(R.id.txtTimerDay);
            txtTimerHour = (TextView) findViewById(R.id.txtTimerHour);
            txtTimerMinute = (TextView) findViewById(R.id.txtTimerMinute);
            txtTimerSecond = (TextView) findViewById(R.id.txtTimerSecond);
            tvEvent = (TextView) findViewById(R.id.tvhappyevent);
            countDownStart();
        }
        public void countDownStart() {
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {
                    handler.postDelayed(this, 1000);
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat(
                                "yyyy-MM-dd");
// Please here set your event date//YYYY-MM-DD
                        Date futureDate = dateFormat.parse(date);
                        Date currentDate = new Date();
                        if (!currentDate.after(futureDate)) {
                            long diff = futureDate.getTime()
                                    - currentDate.getTime();
                            long days = diff / (24 * 60 * 60 * 1000);
                            diff -= days * (24 * 60 * 60 * 1000);
                            long hours = diff / (60 * 60 * 1000);
                            diff -= hours * (60 * 60 * 1000);
                            long minutes = diff / (60 * 1000);
                            diff -= minutes * (60 * 1000);
                            long seconds = diff / 1000;
                            txtTimerDay.setText("" + String.format("%02d", days));
                            txtTimerHour.setText("" + String.format("%02d", hours));
                            txtTimerMinute.setText(""
                                    + String.format("%02d", minutes));
                            txtTimerSecond.setText(""
                                    + String.format("%02d", seconds));
                        } else {
                            tvEvent.setVisibility(View.VISIBLE);
                            tvEvent.setText("The event started!");
                            textViewGone();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            txtTimerDay.postDelayed();
        }
        public void textViewGone() {
            findViewById(R.id.LinearLayout10).setVisibility(View.GONE);
            findViewById(R.id.LinearLayout11).setVisibility(View.GONE);
            findViewById(R.id.LinearLayout12).setVisibility(View.GONE);
            findViewById(R.id.LinearLayout13).setVisibility(View.GONE);
            findViewById(R.id.textView1).setVisibility(View.GONE);
            findViewById(R.id.textView2).setVisibility(View.GONE);
        }
    }


}