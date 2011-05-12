package org.androidtitlan.ac.easymail;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Demo extends Activity {
    protected static final String App = "EasyEmail";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        Button addImage = (Button) findViewById(R.id.send_mail); 
        addImage.setOnClickListener(new View.OnClickListener() {
        private String password = "***";
        private String user = "nrikediaz@gmail.com";

		public void onClick(View view) {
			ACEasyMail mail = new ACEasyMail(user, password);
       
            String[] toArr = {"nrikediaz@androidtitlan.org", "nrikediaz@gmail.com"}; 
            mail.setTo(toArr); 
            mail.setFrom("nrikediaz@gmail.com"); 
            mail.setSubject("This is an email sent using my Mail JavaMail wrapper from an Android device."); 
            mail.setBody("This is a test to send emails with JavaMail libraries for Android"); 
       
            try { 
            	//Adding Attachment to the email :).
//              m.addAttachment("/sdcard/Zelda - Hey!Listen!.mp3"); 
       
              if(mail.send()) { 
                Toast.makeText(getApplicationContext(), "Email was sent successfully.", Toast.LENGTH_LONG).show(); 
              } else { 
                Toast.makeText(getApplicationContext(), "Email was not sent.", Toast.LENGTH_LONG).show(); 
              } 
            } catch(Exception e) { 
              Toast.makeText(getApplicationContext(), "There was a problem sending the email.", Toast.LENGTH_LONG).show(); 
              Log.e(App, "Could not send email: ", e); 
            } 
          } 
        }); 
}
}