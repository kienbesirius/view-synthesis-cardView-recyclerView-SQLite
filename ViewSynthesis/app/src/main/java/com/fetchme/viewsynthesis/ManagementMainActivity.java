package com.fetchme.viewsynthesis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class ManagementMainActivity extends AppCompatActivity {

    private EditText editText_name;
    private EditText editText_birth;
    private EditText editText_university;
    private RadioButton radioButton_male, radioButton_female;
    private CheckBox checkBox_sport, checkBox_travel, checkBox_readBook;
    private Button button_save, button_refill;
    private DataBaseHelper dataBaseHelper;
    private final @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        mapIdToView();
        setupViews();
    }

    public boolean parseDate(String date) {
        try {
            Date DATE = formatter.parse(date);
            return true;
        } catch (Exception e) {
            if (date.equals("")) {
                date = "blank";
            }
            editText_birth.setError("DoB not QUALIFIED! Cause by: " + date);
            editText_birth.setText("");
            return false;
        }
    }

    public String formatDate(String date){
        Date DATE = null;
        if(parseDate(date)){
            try {
                DATE = formatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        assert DATE != null;
        return formatter.format(DATE);
    }
    private void setupViews() {
        button_save.setOnClickListener(view -> {
            Intent intent = getIntent();
            String id = intent.getStringExtra("id");
            String name = editText_name.getText().toString().trim();
            String birth = editText_birth.getText().toString().trim();
            String university = editText_university.getText().toString().trim();
            String sex = radioButton_male.isChecked() ? "male" : "female";
            String hobbies = "";
            boolean birthChecking = parseDate(birth);

            Intent intent1 = new Intent(this, DisplayActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            intent1.putExtras(bundle);

            if(id.equals("bechikien") && name.equalsIgnoreCase("show")){
                startActivity(intent1);
            }
            else if (id.equals("") || name.equals("") || birth.equals("") || university.equals("") || !birthChecking) {
                if (id.equals("")) {
                    Toast.makeText(this, "Insufficient ID", Toast.LENGTH_LONG).show();
                }
                if (name.equals("")) {
                    editText_name.setError("blank name!");
                }
                if (university.equals("")) {
                    editText_university.setError("blank university!");
                }
            } else {

                // Call fragment to show the information have been entered
                if (checkBox_sport.isChecked()) {
                    hobbies += checkBox_sport.getText().toString() + " ";
                }
                if (checkBox_travel.isChecked()) {
                    hobbies += checkBox_travel.getText().toString() + " ";
                }
                if (checkBox_readBook.isChecked()) {
                    hobbies += checkBox_readBook.getText().toString() + " ";
                }
                if (hobbies.equals("")) {
                    hobbies += "Không có sở thích";
                }
                birth = formatDate(birth);
                boolean result = dataBaseHelper.addStudent(new Student(name, birth, university, sex, hobbies, getRandomImg()), id);
                if (result) {
                    Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
                }
                startActivity(intent1);
            }
        });
        button_refill.setOnClickListener(view -> {
            editText_name.setText("");
            editText_birth.setText("");
            editText_university.setText("");
            radioButton_male.setChecked(true);
            radioButton_female.setChecked(false);
            checkBox_sport.setChecked(true);
            checkBox_travel.setChecked(false);
            checkBox_readBook.setChecked(false);
        });

    }

    private void mapIdToView() {
        editText_name = findViewById(R.id.editText_name);
        editText_birth = findViewById(R.id.editText_birth);
        editText_university = findViewById(R.id.editText_university);
        radioButton_male = findViewById(R.id.radioButton_male);
        radioButton_female = findViewById(R.id.radioButton_female);
        checkBox_travel = findViewById(R.id.checkBox_travel);
        checkBox_sport = findViewById(R.id.checkBox_sport);
        checkBox_readBook = findViewById(R.id.checkBox_readBook);
        button_save = findViewById(R.id.button_save);
        button_refill = findViewById(R.id.button_refill);
        dataBaseHelper = new DataBaseHelper(getApplicationContext());
    }

    public static int getRandomImg() {
        Random r = new Random();
        int IMG;
        switch (r.nextInt(38)) {
            case 0: {
                IMG = R.raw.amber;
                break;
            }
            case 1: {
                IMG = R.raw.barbara;
                break;
            }
            case 2: {
                IMG = R.raw.childe;
                break;
            }
            case 3: {
                IMG = R.raw.chongyun;
            }
            case 4: {
                IMG = R.raw.diluc;
                break;
            }
            case 5: {
                IMG = R.raw.eula;
                break;
            }
            case 6: {
                IMG = R.raw.fischl;
                break;
            }
            case 7: {
                IMG = R.raw.ganyu;
            }
            case 8: {
                IMG = R.raw.hutao;
                break;
            }
            case 9: {
                IMG = R.raw.jean;
                break;
            }
            case 10: {
                IMG = R.raw.kaeya;
                break;
            }
            case 11: {
                IMG = R.raw.kamisato_ayaka;
            }
            case 12: {
                IMG = R.raw.kazuha;
                break;
            }
            case 13: {
                IMG = R.raw.keqing;
                break;
            }
            case 14: {
                IMG = R.raw.kujou_sara;
                break;
            }
            case 15: {
                IMG = R.raw.lisa;
            }
            case 16: {
                IMG = R.raw.main_female;
                break;
            }
            case 17: {
                IMG = R.raw.main_male;
                break;
            }
            case 18: {
                IMG = R.raw.mona;
            }
            case 19: {
                IMG = R.raw.ningguang;
                break;
            }
            case 20: {
                IMG = R.raw.noelle;
                break;
            }
            case 21: {
                IMG = R.raw.paimon;
                break;
            }
            case 22: {
                IMG = R.raw.qiqi;
            }
            case 23: {
                IMG = R.raw.razor;
                break;
            }
            case 24: {
                IMG = R.raw.rosaria;
                break;
            }
            case 25: {
                IMG = R.raw.sangonomiya_kokomi;
                break;
            }
            case 26: {
                IMG = R.raw.shenhe;
            }
            case 27: {
                IMG = R.raw.sucrose;
                break;
            }
            case 28: {
                IMG = R.raw.venti;
                break;
            }
            case 29: {
                IMG = R.raw.xiangling;
                break;
            }
            case 30: {
                IMG = R.raw.xiao;
            }
            case 31: {
                IMG = R.raw.xingqiu;
                break;
            }
            case 32: {
                IMG = R.raw.yaemiko;
            }
            case 33: {
                IMG = R.raw.yanfei;
                break;
            }
            case 34: {
                IMG = R.raw.yoimiya;
                break;
            }
            case 35: {
                IMG = R.raw.yun_jin;
                break;
            }
            case 36: {
                IMG = R.raw.zhongli;
            }
            default: {
                IMG = R.raw.raiden_shogun_ei;
            }
        }
        return IMG;
    }
}