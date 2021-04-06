package com.wtechweb.mad_assignment_2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
public class Home extends AppCompatActivity {
    private static final int LENGTH_SHORT = 2000;
    TextView tvWelcome;
    Button button;
    TextView BestId,BestName,AvgId,AvgName,WorstId,WorstName;
    ArrayList<User> result = new ArrayList<>();
    String bName = "";
    String wName = "";
    String element="";
    String wSr = "";
    String bSr = "";
    String aSr="";
    double avg=0.0;
    String avgName="";
    int sr;
    String name;
    String id;
    double score;
    double sum = 0.0;
    double max = -999.9;
    double min = 999.9;
    double temp[]={0.00};
    String outFile="";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
     //   init() ;
        Intent i = getIntent();
        String text= tvWelcome.getText().toString();
        tvWelcome.setText(text+"\n"+i.getStringExtra("username"));
        outFile=i.getStringExtra("filename");
        String filename=i.getStringExtra("filename");
        BestName.setText(element);
        BestId.setText(bSr);
        WorstId.setText(wSr);
        WorstName.setText(wName);
        AvgName.setText(avgName);
        AvgId.setText(aSr);


        writeInFile("C:\\Users\\Abdullah\\AndroidStudioProjects\\MAD_Assignment_2\\app\\src\\main\\assets\\BAW.txt");

    }
    public  void writeInFile(String fileName) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("MAX: " + max + "\n");
            myWriter.write("MIN: " + min + "\n");
            myWriter.write("AVG: " + avg + "\n");
            myWriter.write("Best Name+ ID : " + bName + " " + bSr + "\n");
            myWriter.write("Average Name+ ID : " + avgName + " " + aSr + "\n");
            myWriter.write("Worst Name+ ID : " + wName + " " + wSr + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private void init() {
        tvWelcome=findViewById(R.id.tvWelcome);
        BestName=findViewById(R.id.BestName);
        BestId=findViewById(R.id.BestId);
        WorstId=findViewById(R.id.WorstId);
        WorstName=findViewById(R.id.WorstName);
        AvgId=findViewById(R.id.AvgId);
        AvgName=findViewById(R.id.AvgName);
        String data = "";
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Abdullah\\AndroidStudioProjects\\MAD_Assignment_2\\app\\src\\main\\assets\\data.txt"))) {
            String line1 = null;
            while ((line1 = br.readLine()) != null) {
                while (br.ready()) {
                    data = br.readLine();
                    String[] trimData = data.trim().split("\\s+");
                    sr = Integer.parseInt(trimData[0]);
                    id = trimData[1];
                    name = trimData[2];
                    score = Float.parseFloat(trimData[3]);
                    User obj = new User(sr, id, name, score);
                    result.add(obj);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (User s : result) {
            sum = sum + s.getMarks();
            if (max < s.getMarks()) {
                max = s.getMarks();
                bName = s.getName();
                bSr = s.getId();
            }
            if (min > s.getMarks()) {
                min = s.getMarks();
                wName = s.getName();
                wSr = s.getId();
            }
        }
        double avg = sum / result.size();
        System.out.println("MAX: "+max);
        System.out.println("MIN: "+min);
        System.out.println("AVG: "+avg);
        System.out.println("Best Name+ ID : "+bName+" "+bSr);
        System.out.println("Average Name+ ID : "+avgName+" "+aSr);
        System.out.println("Worst Name+ ID : "+wName+" "+wSr);

        int i=0;
        for (User s : result) {
            if(s.getMarks()-avg<1){
                temp[i]=s.getMarks();
                avgName=s.getName();
                aSr=s.getId();
                break;
            }
        }
    }
}