package irdc.ex03_01;

import android.app.Activity;
import android.os.Bundle;

/*必須引用widget.TextView才能在程式裡宣告TextView物件*/
import android.widget.TextView;

public class EX03_01 extends Activity
{
  /*必須引用widget.TextView才能在程式裡宣告TextView物件*/
  private TextView mTextView01;
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    
    /*載入main.xml Layout，此時myTextView01:text為str_1*/
    setContentView(R.layout.main);
    
    mTextView01 = (TextView) findViewById(R.id.myTextView01);
    
    String str_2 = "歡迎來到Android的TextView世界...";
    mTextView01.setText(str_2);
    
  }
}