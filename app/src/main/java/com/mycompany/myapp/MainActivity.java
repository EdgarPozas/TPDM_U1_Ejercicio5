package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	private EditText valores;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		valores=findViewById(R.id.valores);
    }
	
	public void cambiar(View v){
		if(valores.getText().toString().isEmpty()){
			Toast.makeText(this,"ingresa datos",Toast.LENGTH_SHORT).show();
			return;
		}
		String[] datos=valores.getText().toString().split(",");
		
		for(String s: datos){
			try{
				Integer.parseInt(s);
			}catch(Exception ex){
				Toast.makeText(this,"solo enteros",Toast.LENGTH_SHORT).show();
				return;
			}
		}
		Intent intent=new Intent(this,Activity2.class);
		intent.putExtra("datos",valores.getText().toString());
		startActivity(intent);
	}
}
