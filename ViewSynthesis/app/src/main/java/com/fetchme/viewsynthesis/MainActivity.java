package com.fetchme.viewsynthesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button_login;
    private CheckBox checkBox;
    private EditText editText_id, editText_pass;
    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapIdToView();
        setupViews();
    }

    private void setDataResources() {
        String id = "bechikien";
        String pass = "Admin";
        dataBaseHelper.addAccount(new Account(id, pass));
        dataBaseHelper.addStudent(new Student("Bế Chí Kiên", "15/12/2002", "ICTU", "male", "Không có sở thích", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Triệu Hoàng Đức", "25/01/2002", "ICTU", "male", "Mua khóa học", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Nông Tiến Thành", "16/11/2002", "Công Nghiệp Hà Nội", "male", "Nghe nhạc EDM", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Lâm Hiên", "02/03/340566", "Bách Luyện Thành Tiên", "male", "Lam Sắc Tinh Hải", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Nguyệt Nhi", "07/07/7777", "Bách Luyện Thành Tiên", "female", "Atula Vương", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Vũ Đồng Tiên Tử", "04/02/3948", "Bách Luyện Thành Tiên", "female", "Tiên Giới Cường Giả", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Điền Tiểu Kiếm", "12/08/34115", "Bách Luyện Thành Tiên", "male", "Điền Tương Phân Thần", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Hàn Lập", "03/08/932877", "Phàm Nhân Tu Tiên", "male", "Tiểu Lục Bình", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Trương Vô Kỵ", "01/09/5642", "Bất Hủ Phàm Nhân", "male", "Bất Hủ Phàm Nhân Quyết", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Miêu Nghị", "21/05/4317854", "Phi Thiên", "male", "Tinh Hỏa Quyết", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Đường Tam", "13/07/371556", "Đấu La Đại Lục", "male", "Hạo Thiên Chuy - Lam Ngân Thảo", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Tống Khuyết", "01/03/223002", "Nhất Niệm Vĩnh Hằng", "male", "Bạch Tiểu Thuần", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Mục Nô Kiều", "02/05/4653", "Toàn Chức Pháp Sư", "female", "Mộc Ma Pháp", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Tần Trần", "08/02/54503", "Võ Thần Chúa Tể", "male", "Tiền Kiếp", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("Lăng Hàn", "30/04/200442", "Thần Đạo Đan Tôn", "male", "Hắc Tháp", ManagementMainActivity.getRandomImg()), id);
        dataBaseHelper.addStudent(new Student("La Chinh", "07/06/9174", "Bách Luyện Thành Thần", "male", "Long Đỉnh", ManagementMainActivity.getRandomImg()), id);
    }

    private void setupViews() {
        setDataResources();
        editText_id.setText(dataBaseHelper.renderFirstAccount().getAccount_id());
        editText_pass.setText(dataBaseHelper.renderFirstAccount().getAccount_password());
        button_login.setOnClickListener(view -> {
            String id = editText_id.getText().toString().trim();
            String pass = editText_pass.getText().toString().trim();
            if (id.equals("") || pass.equals("")) {
                if (id.equals("")) {
                    editText_id.setError("id insufficient!");
                }
                if (pass.equals("")) {
                    editText_pass.setError("password insufficient!");
                }
            } else if (id.contains(" ") || pass.contains(" ")) {
                if (id.contains(" ")) {
                    editText_id.setError("id cannot contain SPACE!");
                }
                if (pass.contains(" ")) {
                    editText_pass.setError("password cannot contain SPACE!");
                }
            } else {
                if (checkBox.isChecked()) {
                    boolean result = dataBaseHelper.addAccount(new Account(id, pass));
                    if (result) {
                        Toast.makeText(this, "saved your account!\n" + "welcome user " + id, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "welcome user " + id, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "welcome user " + id, Toast.LENGTH_SHORT).show();
                }
                Bundle attachData = new Bundle();
                attachData.putString("id", id);
                Intent intent = new Intent(getApplicationContext(), ManagementMainActivity.class);
                intent.putExtras(attachData);
                startActivity(intent);
            }

        });
    }

    private void mapIdToView() {
        button_login = findViewById(R.id.button_login);
        checkBox = findViewById(R.id.checkBox);
        editText_id = findViewById(R.id.editText_id);
        editText_pass = findViewById(R.id.editText_pass);
        dataBaseHelper = new DataBaseHelper(getApplicationContext());
    }
}