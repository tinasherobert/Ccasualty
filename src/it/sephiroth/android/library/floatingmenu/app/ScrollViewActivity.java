/*
 * Copyright (C) 2013 Manuel Peinado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.sephiroth.android.library.floatingmenu.app;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;

public class ScrollViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FadingActionBarHelper helper = new FadingActionBarHelper()
        .actionBarBackground(R.drawable.ab_background)
        .headerLayout(R.layout.header)
        .contentLayout(R.layout.activity_scrollview)
       ;
	    setContentView(helper.createView(this));
	    helper.initActionBar(this);
	   // TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
	
	
//	    TabSpec tab1 = tabHost.newTabSpec("First Tab");
//	    TabSpec tab2 = tabHost.newTabSpec("Second Tab");
//	    TabSpec tab3 = tabHost.newTabSpec("Third tab");
//	
//	  
//	    tab1.setIndicator("Tab1");
//	    tab1.setContent(new Intent(this,TabActivity1.class));
//	    
//	    tab2.setIndicator("Tab2");
//	    tab2.setContent(new Intent(this,TabActivity2.class));
//	
//	    tab3.setIndicator("Tab3");
//	    tab3.setContent(new Intent(this,TabActivity3.class));
//	    
//	    
//	    tabHost.addTab(tab1);
//	    tabHost.addTab(tab2);
//	    tabHost.addTab(tab3);
    }

   
}
