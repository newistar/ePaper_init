package com.subratgupta.epaperinit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mDatabase;
    String[] paperName = {"Amar Ujala","Dainik Jagran"};
    String[] city = {"Agra city", "Agra dehat", "Aligarh city", "Aligarh dehat", "Allahabad city", "Allahabad Gangapar", "Allahabad Naini", "Almora", "Ambala", "Ambedkar nagar", "Auraiya", "Azamgarh", "Badaun", "Baghpat", "Bahraich", "Balia", "Banda", "Barabanki", "Bareilly city", "Bareilly dehat", "Basti", "Bhadohi", "Bhiwani", "Bijnor", "Bilaspur", "Bulandsahar", "Chamba", "Chandauli", "Chandigarh city", "Charkhi Dadri", "Dehradun city", "Delhi", "Deoria", "Etah", "Etawa", "Faizabad", "Faridabad", "Farrukhabad", "Fatehabad", "Fatehpur", "Firozabad", "Garhwal", "Ghaziabad", "Ghaziabad-Trans Hindon Area", "Ghazipur", "Gonda-balrampur", "Gorakhpur city", "Gorakhpur dehat", "Greater noida", "Gurugram", "Hamirpur (Himachal)", "Hamirpur (UP)", "Hapur", "Hardoi", "Haridwar", "Hathras", "Hisar", "Jalandhar", "Jalaun", "Jammu city", "Jammu dehat", "Jhajjar", "Jhansi city", "Jhansi dehat", "Jind", "Jounpur", "Jpnagar", "Kaithal", "Kangra", "Kannauj", "Kanpur city", "Kanpur dehat", "Kanpur Ghatampur", "Karnal", "Kathua", "Kaushambi", "Kotdwar", "Kullu", "Kurukshetra", "Kushinagar", "Lakhimpur Kheri", "Lalitpur", "Lucknow city", "Mainpuri", "Mandi", "Mathura", "Mau", "Meerut city", "Meerut dehat", "Mharajgunj", "Mirzapur", "Mohali", "Moradabad city", "Moradabad dehat", "Muzaffarnagar", "Nainital", "Narnaul", "Noida", "Panchkula", "Panipat", "Pilibhit", "Pithoragarh", "Pratapgarh", "Raebareli", "Rajasthan", "Rampur (Himachal)", "Rampur (UP)", "Rewari", "Rishikesh", "Rohtak", "Roorkee", "Saharanpur city", "Saharanpur dehat", "Sambhal", "Santkabirnagar", "Shahjahanpur", "Shamli / muzaffarnagar dehat", "Shimla", "Siddharthnagar", "Sirmaur", "Sirsa", "Sitapur", "Solan", "Sonbhadra", "Sonipat", "Sultanpur", "Udhampur", "Udhamsingh nagar", "Una", "Unnao", "Varanasi", "Vikas nagar", "Yamuna nagar"};
    String[] cityCode = {"ac", "ad", "ct", "dt", "ca", "gp", "na", "al", "am", "an", "au", "az", "bn", "bg", "bh", "bl", "bd", "bb", "cb", "db", "bs", "bo", "bw", "bj", "bp", "bu", "ch", "cd", "cc", "ci", "dc", "dl", "do", "et", "ew", "fz", "fb", "fd", "ft", "fp", "fr", "gh", "ga", "th", "gz", "gb", "gc", "gd", "gn", "gr", "ha", "hm", "hp", "ho", "hd", "ht", "hs", "jl", "ja", "cj", "dj", "jj", "jy", "jd", "jn", "jr", "jp", "kt", "kg", "kj", "kc", "kd", "gm", "kn", "ku", "kh", "kw", "kl", "kk", "ks", "lk", "lt", "lc", "mp", "ma", "mt", "mu", "cm", "dm", "mh", "mz", "ml", "mc", "dh", "mf", "hl", "nn", "nd", "pk", "pn", "pb", "pt", "pg", "rb", "rj", "rm", "rp", "rw", "rk", "rt", "rr", "sc", "st", "sa", "sk", "sp", "md", "sh", "sn", "sm", "sr", "si", "sl", "sb", "so", "su", "um", "us", "un", "uo", "vc", "vk", "ym"};
    String[] date = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String[] page = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        int[] i = {1,2,3};
//        for (int paper: i){
//            Toast.makeText(getApplicationContext(),paper+"",Toast.LENGTH_SHORT).show();
//            link = "https://epaper.amarujala.com/2018/08/"+date+"/dl/01/hdimage.jpg";
//            mDatabase.child("papers").child(paper).child(city[0]).child(date + " Aug 2018").child("page"+i).child("link").setValue(link);
//        }

        mDatabase = FirebaseDatabase.getInstance().getReference();
        forPaper();
    }

    public void forPaper() {

        for (int n=0; n<1; n++){
            //n for paperName and link
            for (int c=0; c<133; c++){
                //c for cityName and citycode
                for (int d=0; d<31; d++){
                    // d for date
                    for (int p=0; p<28; p++){
                        //p for page no.
                        String link = "https://epaper.amarujala.com/2018/08/"+date[d]+"/"+cityCode[c]+"/"+page[p]+"/hdimage.jpg";
                        mDatabase.child("papers").child(paperName[n]).child(city[c]).child(date[d] + " Aug 2018").child("page "+page[p]).child("link").setValue(link);
                    }
                }
            }
        }
    }
}
