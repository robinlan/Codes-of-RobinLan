package irdc.ex03_01;

import android.app.Activity;
import android.os.Bundle;

/*�����ޥ�widget.TextView�~��b�{���̫ŧiTextView����*/
import android.widget.TextView;

public class EX03_01 extends Activity
{
  /*�����ޥ�widget.TextView�~��b�{���̫ŧiTextView����*/
  private TextView mTextView01;
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    
    /*���Jmain.xml Layout�A����myTextView01:text��str_1*/
    setContentView(R.layout.main);
    
    mTextView01 = (TextView) findViewById(R.id.myTextView01);
    
    String str_2 = "�w��Ө�Android��TextView�@��...";
    mTextView01.setText(str_2);
    
  }
}