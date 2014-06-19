package irdc.ex07_07;

import java.io.InputStream;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import android.widget.Gallery.LayoutParams;

public class EX07_07 extends Activity implements 
  AdapterView.OnItemSelectedListener, ViewSwitcher.ViewFactory  
{
  protected static InputStream is;
  private ImageSwitcher mSwitcher;
  private Context mContext;
  
  /*�]�w�bGallery������*/
  private Integer[] mThumbIds = 
  {
      R.drawable.sample_p1, R.drawable.sample_p2, 
      R.drawable.sample_p3, R.drawable.sample_p4,
      R.drawable.sample_p5, R.drawable.sample_p6,
      R.drawable.sample_p7, R.drawable.sample_p8
  };

  /*�]�w�bSwitcher������*/
  private Integer[] mImageIds = 
  {
    R.drawable.p1, R.drawable.p2, R.drawable.p3,
    R.drawable.p4, R.drawable.p5, R.drawable.p6,
    R.drawable.p7, R.drawable.p8
  };
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.main);

    /*�]�wSwitcher*/
    mSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
    mSwitcher.setFactory(this);
    /*�]�w���JSwitcher���Ҧ�*/
    mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
            android.R.anim.slide_in_left));
    /*�]�w��XSwitcher���Ҧ�*/
    mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
            android.R.anim.slide_out_right));

    Gallery g = (Gallery) findViewById(R.id.gallery);
    g.setAdapter(new ImageAdapter(this));
    g.setOnItemSelectedListener(this);
  
    /*�]�w���UGallery���Ϥ��ƥ�*/
    g.setOnItemClickListener(new Gallery.OnItemClickListener() 
    {
      @Override
      public void onItemClick(AdapterView<?> parent, View v, 
          final int position, long id)
      {
        // TODO Auto-generated method stub        
        new AlertDialog.Builder(EX07_07.this)
        .setTitle(R.string.app_about)
        /*�]�w�u�X�������Ϧ�*/
        .setIcon(mImageIds[position]) 
        /*�]�w�u�X�������T��*/
        .setMessage(R.string.app_about_msg)
        /*�T�{����*/
        .setPositiveButton(R.string.str_ok,
        new DialogInterface.OnClickListener()
       {
         public void onClick(DialogInterface dialoginterface,int i)
         {           
          Resources resources = getBaseContext().getResources();
          is = resources.openRawResource(mImageIds[position]);
           try
            {
             /*�󴫮६*/
            setWallpaper(is); 
            /*��Toast����ܮ६�w��*/
            Toast.makeText(EX07_07.this, getString(R.string.
                my_text_pre),Toast.LENGTH_SHORT).show();             
            }
           catch (Exception e)
            {            
            e.printStackTrace();
            };
         }
       })
        /*�]�w���X��������^�ƥ�*/
        .setNegativeButton(R.string.str_no,
         new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface dialoginterface, 
                              int i)   
         {
            /*��Toast����ܮ६�w����*/
            Toast.makeText(EX07_07.this, getString(R.string.
                my_text_no),Toast.LENGTH_SHORT).show();  
         }
        })
        .show();            
      }     
    });
  }  
  
  /*�]�w���JSwitcher������*/
  public void onItemSelected(AdapterView parent, View v,
      int position, long id) 
  {
    mSwitcher.setImageResource(mImageIds[position]);
  }

  public void onNothingSelected(AdapterView parent) 
  {
    
  }

  /*�e�{Switcher���Ҧ�*/
  public View makeView() 
  {
    ImageView i = new ImageView(this);
    i.setBackgroundColor(0xFF000000);
    i.setScaleType(ImageView.ScaleType.FIT_CENTER);
    i.setLayoutParams(new ImageSwitcher.LayoutParams(
        LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
    return i;
  }

  public class ImageAdapter extends BaseAdapter 
  {
    public ImageAdapter(Context c) 
    {
     mContext = c;
    }

    public int getCount() 
    {
      return mImageIds.length;
    }

    public Object getItem(int position)
    {
      return position;
    }

    public long getItemId(int position) 
    {
      return position;
    }

    /*���Gallery�̪��Ҧ�*/
    public View getView(int position, View convertView,
                          ViewGroup parent) 
    {
      ImageView i = new ImageView(mContext);
      i.setImageResource(mThumbIds[position]);
      i.setAdjustViewBounds(true);
      i.setLayoutParams(new Gallery.LayoutParams(
            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
      i.setBackgroundResource(R.drawable.picture_frame);
      return i;
    }
  }
}
