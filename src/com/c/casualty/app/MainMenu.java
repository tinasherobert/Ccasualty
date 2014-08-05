
package com.c.casualty.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu  extends Activity
{
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_menu);
            Button signup = (Button) findViewById(R.id.signup);
            signup.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent(MainMenu.this, UserSignUp.class);
					startActivity(i);
					
				}
			});
            
            Button login = (Button) findViewById(R.id.login);
            login.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent(MainMenu.this, Login.class);
					startActivity(i);
					
				}
			});
        }
}