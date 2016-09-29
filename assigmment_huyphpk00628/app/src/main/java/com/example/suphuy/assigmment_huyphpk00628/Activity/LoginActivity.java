package com.example.suphuy.assigmment_huyphpk00628.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.suphuy.assigmment_huyphpk00628.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity   {
    private FirebaseAuth mAuth;

    LinearLayout buttonDangKy;
    Button buttonDangNhap ;
    EditText editTextUser,editTextPass;
    private Boolean kiemtra=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();
        mAuth = FirebaseAuth.getInstance();
        buttonDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Login_Design_Activity.class);
                startActivity(intent);

            }
        });
//        buttonDangKy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dangky();
//            }
//        });
//    }
//    private void dangnhap(){
//
//        String email=editTextUser.getText().toString().trim();
//        String password=editTextPass.getText().toString().trim();
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                        if (!task.isSuccessful()) {
//
//                            Toast.makeText(LoginActivity.this,"lỗi ",
//                                    Toast.LENGTH_SHORT).show();
//                        }else
//                        {
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                            startActivity(intent);
//                            overridePendingTransition(R.anim.right_in, R.anim.left_out);
//                            Toast.makeText(LoginActivity.this,"đăng nhập thành công ",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//    }
//   private void dangky(){
//       String email=editTextUser.getText().toString().trim();
//       String password=editTextPass.getText().toString().trim();
//       mAuth.createUserWithEmailAndPassword(email, password)
//               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                   @Override
//                   public void onComplete(@NonNull Task<AuthResult> task) {
//
//                       if (!task.isSuccessful()) {
//                           Toast.makeText(LoginActivity.this,"lỗi ",
//                                   Toast.LENGTH_SHORT).show();
//                       }else
//                       {
//                           Toast.makeText(LoginActivity.this,"đăng ký thành công ",
//                                   Toast.LENGTH_SHORT).show();
//                       }
//
//                   }
//               });
   }
private void anhxa(){
    buttonDangNhap=(Button)findViewById(R.id.btnlogin);
    buttonDangKy=(LinearLayout)findViewById(R.id.lnRegister);
    editTextUser=(EditText)findViewById(R.id.editEmail) ;
    editTextPass=(EditText)findViewById(R.id.editPass) ;
}

}
