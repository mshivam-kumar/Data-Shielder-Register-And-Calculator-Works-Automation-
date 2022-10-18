package com.datahiveshield.mydata.mydairy.khata.files.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.datahiveshield.mydata.mydairy.khata.files.model.Contact;
import com.datahiveshield.mydata.mydairy.khata.files.model.CustomerNames;
import com.datahiveshield.mydata.mydairy.khata.files.params.Params;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyDbHandlerIndividualPerson extends SQLiteOpenHelper {
    public static SQLiteDatabase db1;
    public Context context;

    //    Context context;
    public MyDbHandlerIndividualPerson(Context context)
    {

//        super(context, Params.DATATABSE_DIRECTORY_NAME,null,Params.DB_VERSION);
//                + File.separator + "/."+Params.EmailId+"/"+ Params.DB_NAME
        super(context, context.getExternalFilesDir(null).getAbsolutePath()
                +File.separator+"/."+Params.EmailId+"/"+Params.DEFAULT_INDIVIDUAL_PERSON_DATA_NAME+"/"+Params.youWillGetOrGiveMoneyButtonPressed+"/"+ Params.CURRENT_GROUP_DB_NAME
                + File.separator
                + Params.DB_NAME,null,Params.DB_VERSION);

        this.context=context;
        //Log.d("dbsvm","\nGroup  location : "+context.getExternalFilesDir(null).getAbsolutePath()

//                + File.separator + "/."+Params.EmailId+"/"+Params.DB_NAME
//                + File.separator
//                + Params.DB_NAME);
        //For default data
//            super(context, Params.DEFAULT_DATA_DB_NAME, null, Params.DEFAULT_DATA_DB_VERSION);

//        //Log.d("dbsvm","inside MyDbHandler");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Log.d("dbsvm","inside  MyDbHandler.java");

        //Creating table in database
//        String create="CREATE TABLE "+Params.TABLE_NAME+"("+
//                Params.KEY_ID+" INTEGER PRIMARY KEY,"+
//                Params.KEY_NAME+" TEXT, "+Params.KEY_PHONE+" TEXT "+")";
////        String create="DROP TABLE "+Params.TABLE_NAME;
//            db1=db;
        //Log.d("dbsvm","inside MyDbHandler");
//            createDefaultDataTableForTextBoxes(db);//Create table to  store default data into texboxes


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        //Log.d("dbsvm","inside onUpgrade method");
//        db.execSQL("DROP TABLE IF EXISTS "+Params.DEFAULT_DATA_TABLE_NAME);
//        //Log.d("dbsvm","table dropped");
//        onCreate(db);
    }

    public void createValueStoringTable(SQLiteDatabase db)//Main table to store value data of customers
    {
        try {
            String create = "CREATE TABLE IF NOT EXISTS " + Params.DATA_TABLE_NAME + "(" +
                    Params.DATE + " VARCHAR(10) PRIMARY KEY  , " +
                    Params.C1 + " DECIMAL(5,2) NOT NULL, " + Params.C2 + " DECIMAL(5,2) NOT NULL , " +
                    Params.C3 + " DECIMAL(5,2) NOT NULL , " + Params.C4 + " DECIMAL(5,2) NOT NULL , " +
                    Params.C5 + " DECIMAL(5,2) NOT NULL , " + Params.C6 + " DECIMAL(5,2) NOT NULL , " +
                    Params.C7 + " DECIMAL(5,2) NOT NULL , " + Params.C8 + " DECIMAL(5,2) NOT NULL ," +
                    Params.C9 + " DECIMAL(5,2) NOT NULL , " + Params.C10 + " DECIMAL(5,2) NOT NULL , " +
                    Params.C11 + " DECIMAL(5,2) NOT NULL , " + Params.C12 + " DECIMAL(5,2) NOT NULL , " +
                    Params.C13 + " DECIMAL(5,2) NOT NULL , " + Params.C14 + " DECIMAL(5,2) NOT NULL , " +
                    Params.C15 + " DECIMAL(5,2) NOT NULL " + ")";

            //Log.d("dbsvm", "Query being run : " + create);
            db.execSQL(create);
//            //Log.d("dbsvm", " Main contacts_db Table created");

//            db.execSQL("DROP TABLE IF EXISTS "+Params.TABLE_NAME);
//                   //Log.d("dbsvm"," Main contacts_db table dropped");
//
        }
        catch (Exception e)
        {
            //Log.d("dbsvm",e.getMessage().toString());
        }

    }

    public void createDefaultDataTableForTextBoxes(SQLiteDatabase db)//used once to create table inside MainActivity.java
    {
        try {
            String create = "CREATE TABLE IF NOT EXISTS " + Params.DEFAULT_DATA_TABLE_NAME + "(" +
                    Params.RATE + " DECIMAL(5,2), " +
                    Params.C1 + " DECIMAL(5,2), " + Params.C2 + " DECIMAL(5,2), " +
                    Params.C3 + " DECIMAL(5,2), " + Params.C4 + " DECIMAL(5,2) , " +
                    Params.C5 + " DECIMAL(5,2), " + Params.C6 + " DECIMAL(5,2), " +
                    Params.C7 + " DECIMAL(5,2), " + Params.C8 + " DECIMAL(5,2)," +
                    Params.C9 + " DECIMAL(5,2), " + Params.C10 + " DECIMAL(5,2), " +
                    Params.C11 + " DECIMAL(5,2), " + Params.C12 + " DECIMAL(5,2), " +
                    Params.C13 + " DECIMAL(5,2), " + Params.C14 + " DECIMAL(5,2), " +
                    Params.C15 + " DECIMAL(5,2), " +  Params.QUANTITYUNITNAME + " VARCHAR(5)"+")";

            //Log.d("dbsvm", "Query being run : \n" + create);
            try {
                db.execSQL(create);
                //Log.d("dbsvm", "Default Data Table created successfully");

//                db.execSQL("DELETE FROM "+Params.DEFAULT_DATA_TABLE_NAME);
//                //Log.d("dbsvm","Default data table cleared");

//                   db.execSQL("DROP TABLE IF EXISTS "+Params.DEFAULT_DATA_TABLE_NAME);
//                   //Log.d("dbsvm","table dropped");
//
            }
            catch (Exception e)
            {
                Log.d("dbsvm","Unable to create default data table Error :" +
                        e.getMessage().toString());
            }
        }
        catch (Exception e)
        {
            //Log.d("dbsvm",e.getMessage().toString());
        }

    }

    //Create table for customer names , taking data from CustomerNames.java
    public void createDefaultCustomerNames(SQLiteDatabase db)
    {
        try {
            String create = "CREATE TABLE IF NOT EXISTS " + Params.DEFAULT_CUSTOMER_NAMES_TABLE + "(" +
                    Params.NAME1 + " VARCHAR(20) NOT NULL  , " +
                    Params.NAME2 + " VARCHAR(20) NOT NULL, " + Params.NAME3 + " VARCHAR(20) NOT NULL , " +
                    Params.NAME4 + " VARCHAR(20) NOT NULL , " + Params.NAME5 + " VARCHAR(20) NOT NULL , " +
                    Params.NAME6 + " VARCHAR(20) NOT NULL , " + Params.NAME7 + " VARCHAR(20) NOT NULL , " +
                    Params.NAME8 + " VARCHAR(20) NOT NULL , " + Params.NAME9 + " VARCHAR(20) NOT NULL ," +
                    Params.NAME10 + " VARCHAR(20) NOT NULL , " + Params.NAME11 + " VARCHAR(20) NOT NULL , " +
                    Params.NAME12 + " VARCHAR(20) NOT NULL , " + Params.NAME13 + " VARCHAR(20) NOT NULL , " +
                    Params.NAME14 + " VARCHAR(20) NOT NULL , " + Params.NAME15 + " VARCHAR(20) NOT NULL " + ")";

            //Log.d("dbsvm", "Query being run\n : " + create);
            db.execSQL(create);
            //Log.d("dbsvm", " Default customer names Table created");

//            db.execSQL("DROP TABLE IF EXISTS "+Params.TABLE_NAME);
//                   //Log.d("dbsvm"," Main contacts_db table dropped");
//
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Inside MyDbHandler unable to create default customer names table\n"+e.getMessage().toString());
        }

    }

    public  void clearDefaultCustomerNamesTable(SQLiteDatabase db)
    {
//                        db.execSQL("DELETE FROM "+Params.DEFAULT_DATA_TABLE_NAME);
//                        //Log.d("dbsvm","Default data table cleared");

        db.execSQL("DROP TABLE IF EXISTS "+Params.DEFAULT_CUSTOMER_NAMES_TABLE);
        //Log.d("dbsvm"," Default Customer Names table dropped");
    }

    public int isDefaultCustomerDataRowExist() {

        SQLiteDatabase db = getWritableDatabase();
        String selectString = "SELECT * FROM " + Params.DEFAULT_CUSTOMER_NAMES_TABLE;

        // Add the String you are searching by here.
        // Put it in an array to avoid an unrecognized token error
        Cursor cursor = db.rawQuery(selectString, null);

//        boolean hasObject = false;
        int flag=0;//does not exist
        if(cursor.moveToFirst()){
//            hasObject = true;
            flag=1;
            //region if you had multiple records to check for, use this region.

            int count = 0;
            while(cursor.moveToNext()){
                count++;
            }
            //here, count is records found
//            //Log.d("dbsvm", String.format("%d records found", count));

            //endregion

        }

        cursor.close();          // Dont forget to close your cursor
        db.close();              //AND your Database!
        return flag;
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertDefaultCustomerData(CustomerNames contact)//used only once inside insert button InsertDataDb.java
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
//            values.put(Params.C1, contact.getC1());
//            values.put(Params.C2, contact.getC2());
//            //Log.d("sk", "Successfully inserted");

            values.put(String.valueOf(Params.NAME1),contact.getNAME1());
            values.put(String.valueOf(Params.NAME2), contact.getNAME2());
            values.put(String.valueOf(Params.NAME3), contact.getNAME3());
            values.put(String.valueOf(Params.NAME4), contact.getNAME4());
            values.put(String.valueOf(Params.NAME5), contact.getNAME5());
            values.put(String.valueOf(Params.NAME6), contact.getNAME6());
            values.put(String.valueOf(Params.NAME7), contact.getNAME7());
            values.put(String.valueOf(Params.NAME8), contact.getNAME8());
            values.put(String.valueOf(Params.NAME9), contact.getNAME9());
            values.put(String.valueOf(Params.NAME10), contact.getNAME10());
            values.put(String.valueOf(Params.NAME11), contact.getNAME11());
            values.put(String.valueOf(Params.NAME12), contact.getNAME12());
            values.put(String.valueOf(Params.NAME13), contact.getNAME13());
            values.put(String.valueOf(Params.NAME14), contact.getNAME14());
            values.put(String.valueOf(Params.NAME15), contact.getNAME15());

            db.insert(Params.DEFAULT_CUSTOMER_NAMES_TABLE, null, values);
            //Log.d("dbsvm", "Default customer data inserted");
            db.close();
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Unbale to insert default customer data, Error: "+e.getMessage().toString());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateDefaultCustomerData(CustomerNames contact)//used only once inside insert button InsertDataDb.java
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
//            values.put(Params.C1, contact.getC1());
//            values.put(Params.C2, contact.getC2());
//            //Log.d("sk", "Successfully inserted");

            values.put(String.valueOf(Params.NAME1),contact.getNAME1());
            values.put(String.valueOf(Params.NAME2), contact.getNAME2());
            values.put(String.valueOf(Params.NAME3), contact.getNAME3());
            values.put(String.valueOf(Params.NAME4), contact.getNAME4());
            values.put(String.valueOf(Params.NAME5), contact.getNAME5());
            values.put(String.valueOf(Params.NAME6), contact.getNAME6());
            values.put(String.valueOf(Params.NAME7), contact.getNAME7());
            values.put(String.valueOf(Params.NAME8), contact.getNAME8());
            values.put(String.valueOf(Params.NAME9), contact.getNAME9());
            values.put(String.valueOf(Params.NAME10), contact.getNAME10());
            values.put(String.valueOf(Params.NAME11), contact.getNAME11());
            values.put(String.valueOf(Params.NAME12), contact.getNAME12());
            values.put(String.valueOf(Params.NAME13), contact.getNAME13());
            values.put(String.valueOf(Params.NAME14), contact.getNAME14());
            values.put(String.valueOf(Params.NAME15), contact.getNAME15());

//            db.insert(Params.DEFAULT_CUSTOMER_NAMES_TABLE, null, values);
//            //Log.d("dbsvm", "Default customer data inserted");
            db.update(Params.DEFAULT_CUSTOMER_NAMES_TABLE, values, null,null);
            //Log.d("dbsvm", "Default customer data updated except milk rate inside MyDBHandler");

            db.close();
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Unbale to insert default customer data, Error: "+e.getMessage().toString());
        }
    }

    public  void clearDefaultValueDataTable(SQLiteDatabase db)
    {
//                        db.execSQL("DELETE FROM "+Params.DEFAULT_DATA_TABLE_NAME);
//                        //Log.d("dbsvm","Default data table cleared");

        db.execSQL("DROP TABLE IF EXISTS "+Params.DEFAULT_DATA_TABLE_NAME);
        //Log.d("dbsvm"," Default Values table dropped");


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public CustomerNames getDefaultCustomerDataForTextBoxes(){
//        List<Contact> contactList=new ArrayList<>();
//        List<Contact> contactList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        //Generate the query to read from database
//        Contact contact=new Contact();
        CustomerNames contact=new CustomerNames();
        try {

            String select = "SELECT * FROM " + Params.DEFAULT_CUSTOMER_NAMES_TABLE;
//        String select="SELECT * FROM "+Params.DEFAULT_DATA_TABLE_NAME;

            Cursor cursor = db.rawQuery(select, null);
            //Loop through now
            if (cursor.moveToFirst()) {
//                do {
//                    Contact contact = new Contact();
//                    contact.setDATE(cursor.getString(0));
                contact.setNAME1(cursor.getString(0));
                contact.setNAME2(cursor.getString(1));
                contact.setNAME3(cursor.getString(2));
                contact.setNAME4(cursor.getString(3));
                contact.setNAME5(cursor.getString(4));
                contact.setNAME6(cursor.getString(5));
                contact.setNAME7(cursor.getString(6));
                contact.setNAME8(cursor.getString(7));
                contact.setNAME9(cursor.getString(8));
                contact.setNAME10(cursor.getString(9));
                contact.setNAME11(cursor.getString(10));
                contact.setNAME13(cursor.getString(11));
                contact.setNAME12(cursor.getString(12));
                contact.setNAME14(cursor.getString(13));
                contact.setNAME15(cursor.getString(14));

//                    contactList.add(contact);
//                } while (cursor.moveToNext());
            }
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Unable to fetch default customer data "+e.getMessage().toString());
        }
        return contact;
    }


    //    public void updateDefaultValueData(Contact contact,int key)
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertDefaultValueData(Contact contact)//used only once inside insert button InsertDataDb.java
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
//            values.put(Params.C1, contact.getC1());
//            values.put(Params.C2, contact.getC2());

            values.put(String.valueOf(Params.RATE),Contact.getRate());
//            //Log.d("sk", "Successfully inserted");

            values.put(String.valueOf(Params.C1), contact.getC1());
            values.put(String.valueOf(Params.C2), contact.getC2());
            values.put(String.valueOf(Params.C3), contact.getC3());
            values.put(String.valueOf(Params.C4), contact.getC4());
            values.put(String.valueOf(Params.C5), contact.getC5());
            values.put(String.valueOf(Params.C6), contact.getC6());
            values.put(String.valueOf(Params.C7), contact.getC7());
            values.put(String.valueOf(Params.C8), contact.getC8());
            values.put(String.valueOf(Params.C9), contact.getC9());
            values.put(String.valueOf(Params.C10), contact.getC10());
            values.put(String.valueOf(Params.C11), contact.getC11());
            values.put(String.valueOf(Params.C12), contact.getC12());
            values.put(String.valueOf(Params.C13), contact.getC13());
            values.put(String.valueOf(Params.C14), contact.getC14());
            values.put(String.valueOf(Params.C15), contact.getC15());
            values.put(String.valueOf(Params.QUANTITYUNITNAME), contact.getQUANTITYUNITNAME());


            db.insert(Params.DEFAULT_DATA_TABLE_NAME, null, values);
            //Log.d("dbsvm", "Default data inserted");
            db.close();
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Unbale to insert default data, Error: "+e.getMessage().toString());
        }
    }

    public int isDefaultValueDataRowExist() {

        SQLiteDatabase db = getWritableDatabase();
        String selectString = "SELECT * FROM " + Params.DEFAULT_DATA_TABLE_NAME;

        // Add the String you are searching by here.
        // Put it in an array to avoid an unrecognized token error
        Cursor cursor = db.rawQuery(selectString, null);

//        boolean hasObject = false;
        int flag=0;//does not exist
        if(cursor.moveToFirst()){
//            hasObject = true;
            flag=1;
            //region if you had multiple records to check for, use this region.

            int count = 0;
            while(cursor.moveToNext()){
                count++;
            }
            //here, count is records found
//            //Log.d("dbsvm", String.format("%d records found", count));

            //endregion

        }

        cursor.close();          // Dont forget to close your cursor
        db.close();              //AND your Database!
        return flag;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateDefaultData(Contact contact,int key)
    {

//        key==1 to update Rate and unit , used inside TableTotalView.java
//        key==0 to udpate values in InsertDbData.java textBoxes other than milk_rate
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        try {
//            values.put(Params.C1, contact.getC1());
//            values.put(Params.C2, contact.getC2());

            if (key == 1) {
                values.put(String.valueOf(Params.RATE), Contact.getRate());
                values.put(String.valueOf(Params.QUANTITYUNITNAME), contact.getQUANTITYUNITNAME());

                db.update(Params.DEFAULT_DATA_TABLE_NAME, values, null,null);
                //Log.d("dbsvm", "Default milk rate updated successfully");
            } else {
//                        values.put(String.valueOf(Params.MILK_RATE), Contact.getMilk_rate());

                values.put(String.valueOf(Params.C1), contact.getC1());
//                values.put(String.valueOf(Params.C1), 2.5);

                values.put(String.valueOf(Params.C2), contact.getC2());
                values.put(String.valueOf(Params.C3), contact.getC3());
                values.put(String.valueOf(Params.C4), contact.getC4());
                values.put(String.valueOf(Params.C5), contact.getC5());
                values.put(String.valueOf(Params.C6), contact.getC6());
                values.put(String.valueOf(Params.C7), contact.getC7());
                values.put(String.valueOf(Params.C8), contact.getC8());
                values.put(String.valueOf(Params.C9), contact.getC9());
                values.put(String.valueOf(Params.C10), contact.getC10());
                values.put(String.valueOf(Params.C11), contact.getC11());
                values.put(String.valueOf(Params.C12), contact.getC12());
                values.put(String.valueOf(Params.C13), contact.getC13());
                values.put(String.valueOf(Params.C14), contact.getC14());
                values.put(String.valueOf(Params.C15), contact.getC15());

                db.update(Params.DEFAULT_DATA_TABLE_NAME, values, null,null);
                //Log.d("dbsvm", "Default data updated except milk rate inside MyDBHandler");
            }

            db.close();
        }
        catch (Exception e)
        {
//                    //Log.d("dbsvm","Inside myDbHandler unable to update inserted data as default data "+
//                            e1.getMessage().toString());
            //Log.d("dbsvm","Unbale to update default data, Error: "+e.getMessage().toString());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Contact getDefaultDataForTextBoxes(){
//        List<Contact> contactList=new ArrayList<>();
//        List<Contact> contactList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        //Generate the query to read from database
        Contact contact=new Contact();
        try {

            String select = "SELECT * FROM " + Params.DEFAULT_DATA_TABLE_NAME;
//        String select="SELECT * FROM "+Params.DEFAULT_DATA_TABLE_NAME;

            Cursor cursor = db.rawQuery(select, null);
            //Loop through now
            if (cursor.moveToFirst()) {
//                do {
//                    Contact contact = new Contact();
//                    contact.setDATE(cursor.getString(0));
                Contact.setRate(Double.parseDouble(cursor.getString(0)));
                contact.setC1(Double.parseDouble(cursor.getString(1)));
                contact.setC2(Double.parseDouble(cursor.getString(2)));
                contact.setC3(Double.parseDouble(cursor.getString(3)));
                contact.setC4(Double.parseDouble(cursor.getString(4)));
                contact.setC5(Double.parseDouble(cursor.getString(5)));
                contact.setC6(Double.parseDouble(cursor.getString(6)));
                contact.setC7(Double.parseDouble(cursor.getString(7)));
                contact.setC8(Double.parseDouble(cursor.getString(8)));
                contact.setC9(Double.parseDouble(cursor.getString(9)));
                contact.setC10(Double.parseDouble(cursor.getString(10)));
                contact.setC11(Double.parseDouble(cursor.getString(11)));
                contact.setC12(Double.parseDouble(cursor.getString(12)));
                contact.setC13(Double.parseDouble(cursor.getString(13)));
                contact.setC14(Double.parseDouble(cursor.getString(14)));
                contact.setC15(Double.parseDouble(cursor.getString(15)));
                Contact.setQUANTITYUNITNAME(cursor.getString(16));


//                    contactList.add(contact);
//                } while (cursor.moveToNext());
            }
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Unable to fetch default data "+e.getMessage().toString());
        }
        return contact;
    }

    public void clearTable() {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("delete from " + Params.DATA_TABLE_NAME);
//            db.execSQL("DROP TABLE IF EXISTS "+Params.TABLE_NAME);//Table deleted
            //Log.d("dbsvm", "table data cleared");
            db.close();
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Error in deleting table :"+e.getMessage().toString());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void deleteData() {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
//            db.execSQL("delete from " + Params.TABLE_NAME+" where "+Params.DATE+"="+Contact.selectedDate);
//            db.execSQL("DROP TABLE IF EXISTS "+Params.TABLE_NAME);//Table deleted
//            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(Params.DATA_TABLE_NAME, Params.DATE +"=?", new String[]{String.valueOf(Contact.selectedDate)});
            db.close();
            //Log.d("dbsvm", "Data deleted");
            db.close();
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Error in deleting table :"+e.getMessage().toString());
        }
    }


    //Tells whether record for particulat date (passed) exists or not
    public int isDateExist(String date) {

        SQLiteDatabase db = getWritableDatabase();
        String selectString = "SELECT * FROM " + Params.DATA_TABLE_NAME + " WHERE " + Params.DATE + " =?";

        // Add the String you are searching by here.
        // Put it in an array to avoid an unrecognized token error
        Cursor cursor = db.rawQuery(selectString, new String[] {date});

//        boolean hasObject = false;
        int flag=0;//does not exist
        if(cursor.moveToFirst()){
//            hasObject = true;
            flag=1;
            //region if you had multiple records to check for, use this region.

            int count = 0;
            while(cursor.moveToNext()){
                count++;
            }
            //here, count is records found
            //Log.d("dbsvm", String.format("%d records found", count));

            //endregion

        }

        cursor.close();          // Dont forget to close your cursor
        db.close();              //AND your Database!
        return flag;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
//public void addContact()
    public int insertData(Contact contact)
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
//            values.put(Params.C1, contact.getC1());
//            values.put(Params.C2, contact.getC2());

            values.put(Params.DATE,contact.getDATE());
//            //Log.d("sk", "Successfully inserted");

            values.put(String.valueOf(Params.C1), contact.getC1());
            values.put(String.valueOf(Params.C2), contact.getC2());
            values.put(String.valueOf(Params.C3), contact.getC3());
            values.put(String.valueOf(Params.C4), contact.getC4());
            values.put(String.valueOf(Params.C5), contact.getC5());
            values.put(String.valueOf(Params.C6), contact.getC6());
            values.put(String.valueOf(Params.C7), contact.getC7());
            values.put(String.valueOf(Params.C8), contact.getC8());
            values.put(String.valueOf(Params.C9), contact.getC9());
            values.put(String.valueOf(Params.C10), contact.getC10());
            values.put(String.valueOf(Params.C11), contact.getC11());
            values.put(String.valueOf(Params.C12), contact.getC12());
            values.put(String.valueOf(Params.C13), contact.getC13());
            values.put(String.valueOf(Params.C14), contact.getC14());
            values.put(String.valueOf(Params.C15), contact.getC15());

            db.insert(Params.DATA_TABLE_NAME, null, values);
            //Log.d("dbsvm", "Successfully inserted");
            db.close();

            return 1;//notify caller (class) that data is being inserted
            //flag is returned to handle alertBoxes, to show msg to user
            //if tries to insert data with the exiting date in database

//            GetAlerts ga=new GetAlerts();
//            ga.alertDialogBox(null, "Date : "+contact.getDATE() + "  record inserted", "Record Inserted");

        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Unbale to insert, Error: "+e.getMessage().toString());
            return 0;
        }
//        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateData(Contact contact)
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
//            values.put(Params.C1, contact.getC1());
//            values.put(Params.C2, contact.getC2());

            values.put(Params.DATE,contact.getDATE());
//            //Log.d("sk", "Successfully inserted");

            values.put(String.valueOf(Params.C1), contact.getC1());
            values.put(String.valueOf(Params.C2), contact.getC2());
            values.put(String.valueOf(Params.C3), contact.getC3());
            values.put(String.valueOf(Params.C4), contact.getC4());
            values.put(String.valueOf(Params.C5), contact.getC5());
            values.put(String.valueOf(Params.C6), contact.getC6());
            values.put(String.valueOf(Params.C7), contact.getC7());
            values.put(String.valueOf(Params.C8), contact.getC8());
            values.put(String.valueOf(Params.C9), contact.getC9());
            values.put(String.valueOf(Params.C10), contact.getC10());
            values.put(String.valueOf(Params.C11), contact.getC11());
            values.put(String.valueOf(Params.C12), contact.getC12());
            values.put(String.valueOf(Params.C13), contact.getC13());
            values.put(String.valueOf(Params.C14), contact.getC14());
            values.put(String.valueOf(Params.C15), contact.getC15());

//            db.update(Params.TABLE_NAME, values, "",new String[]{contact.getSelectedDate()});
            db.update(Params.DATA_TABLE_NAME, values, Params.DATE + "=?" ,
                    new String[]{String.valueOf(contact.getDATE())});

//            db.update(Params.TABLE_NAME, values, "date = ?",null);

//            db.insert(Params.TABLE_NAME, null, values);
            //Log.d("dbsvm", "Successfully updated");
            db.close();
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Unbale to insert, Error: "+e.getMessage().toString());
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<Contact> getAllSavedRecords(){
        List<Contact> contactList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        //Generate the query to read from database
        String select="SELECT * FROM "+Params.DATA_TABLE_NAME+" ORDER BY substr("+Params.DATE+",0,2 "+") Desc limit 1";
//        String select="SELECT * FROM "+Params.DATA_TABLE_NAME+" ORDER BY " +Params.DATE+" DESC";

//        String select="SELECT * FROM "+Params.DEFAULT_DATA_TABLE_NAME;

        Cursor cursor=db.rawQuery(select,null);
        //Loop through now
        if(cursor.moveToFirst())
        {
            do{
                Contact contact=new Contact();
                contact.setDATE(cursor.getString(0));
                contact.setC1(Double.parseDouble(cursor.getString(1)));
                contact.setC2(Double.parseDouble(cursor.getString(2)));
                contact.setC3(Double.parseDouble(cursor.getString(3)));
                contact.setC4(Double.parseDouble(cursor.getString(4)));
                contact.setC5(Double.parseDouble(cursor.getString(5)));
                contact.setC6(Double.parseDouble(cursor.getString(6)));
                contact.setC7(Double.parseDouble(cursor.getString(7)));
                contact.setC8(Double.parseDouble(cursor.getString(8)));
                contact.setC9(Double.parseDouble(cursor.getString(9)));
                contact.setC10(Double.parseDouble(cursor.getString(10)));
                contact.setC11(Double.parseDouble(cursor.getString(11)));
                contact.setC12(Double.parseDouble(cursor.getString(12)));
                contact.setC13(Double.parseDouble(cursor.getString(13)));
                contact.setC14(Double.parseDouble(cursor.getString(14)));
                contact.setC15(Double.parseDouble(cursor.getString(15)));

                contactList.add(contact);
            }while (cursor.moveToNext());
        }

        return contactList;
    }

    public void createCustomerGroupDatabaseStoringTable(SQLiteDatabase db)
    {
        try {
            String create = "CREATE TABLE IF NOT EXISTS " + Params.ToStoreCustomerGroupsDatabase + "(" +
                    Params.CustomerGroupCreatedDatabaseName + " VARCHAR(20) PRIMARY KEY" + ")";

            //Log.d("dbsvm", "Query being run\n : " + create);
            db.execSQL(create);
            //Log.d("dbsvm", "ToStoreCustomerGroupsTableName Table created successfully");

//            db.execSQL("DROP TABLE IF EXISTS "+Params.TABLE_NAME);
//                   //Log.d("dbsvm"," Main contacts_db table dropped");
//
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","ToStoreCustomerGroupsTableName "+e.getMessage().toString());
        }

    }


    //Tells whether record for particulat date (passed) exists or not
    public int isCustomerGroupDatabaseExist(String tableName) {

        SQLiteDatabase db = getWritableDatabase();
        String selectString = "SELECT * FROM " + Params.ToStoreCustomerGroupsDatabase + " WHERE " + Params.CustomerGroupCreatedDatabaseName + " =?";

        // Add the String you are searching by here.
        // Put it in an array to avoid an unrecognized token error
        Cursor cursor = db.rawQuery(selectString, new String[] {tableName});

//        boolean hasObject = false;
        int flag=0;//does not exist
        if(cursor.moveToFirst()){
//            hasObject = true;
            flag=1;
            //region if you had multiple records to check for, use this region.

            int count = 0;
            while(cursor.moveToNext()){
                count++;
            }
            //here, count is records found
            //Log.d("dbsvm", String.format("%d records found", count));

            //endregion

        }

        cursor.close();          // Dont forget to close your cursor
        db.close();              //AND your Database!
        return flag;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
//public void addContact()
    public void insertCustomerGroupDatabaseNameIntoTable(String newDatabaseName)
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
//            values.put(Params.C1, contact.getC1());
//            values.put(Params.C2, contact.getC2());

            values.put(Params.CustomerGroupCreatedDatabaseName,newDatabaseName);
//            //Log.d("sk", "Successfully inserted");


            db.insert(Params.ToStoreCustomerGroupsDatabase, null, values);
            //Log.d("dbsvm", "CustomerGroupTable Successfully inserted");
            db.close();

            //notify caller (class) that data is being inserted
            //flag is returned to handle alertBoxes, to show msg to user
            //if tries to insert data with the exiting date in database

//            GetAlerts ga=new GetAlerts();
//            ga.alertDialogBox(null, "Date : "+contact.getDATE() + "  record inserted", "Record Inserted");

        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Unbale to insert Customer Group Table, Error: "+e.getMessage().toString());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateCustomerGroupDatabaseStoringTable(String oldName,String newDbName)
    //Need to run and debug
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
//            values.put(Params.C1, contact.getC1());
//            values.put(Params.C2, contact.getC2());

            values.put(Params.CustomerGroupCreatedDatabaseName,newDbName);
//            //Log.d("sk", "Successfully inserted");

//            db.update(Params.ToStoreCustomerGroupsDatabase, values, Params.CustomerGroupCreatedDatabaseName + "=?" ,
//                    new String[]{String.valueOf(newDbName)});
            db.update(Params.ToStoreCustomerGroupsDatabase, values, Params.CustomerGroupCreatedDatabaseName + "=?" ,
                    new String[]{String.valueOf(oldName)});

//            db.execSQL("Attach "+Params.DB_NAME+" AS "+" newDbName;");
//            db.update(Params.TABLE_NAME, values, "date = ?",null);

//            db.execSQL("ALTER DATABASE MyTestDatabase SET SINGLE_USER WITH ROLLBACK IMMEDIATE");
//            db.execSQL("ALTER DATABASE MyTestDatabase MODIFY NAME = MyTestDatabaseCopy") ;
//            db.execSQL("ALTER DATABASE MyTestDatabaseCopy SET MULTI_USER");
//            db.insert(Params.TABLE_NAME, null, values);
            //Log.d("dbsvm", "CustomerGroupTable Successfully updated");
            db.close();
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Unbale to update CustomerGroupTable, Error: "+e.getMessage().toString());
        }
    }

    public  void changeCustomerGroupName(String oldDbName,String newDbName)
    {
        try {

            SQLiteDatabase db = this.getWritableDatabase();

//            String storage_folder = context.getExternalFilesDir(null).getAbsolutePath()+"/."+Params.EmailId+"/"+oldDbName;
//            String new_storage_folder=context.getExternalFilesDir(null).getAbsolutePath()+"/."+Params.EmailId+"/"+newDbName;
            String storage_folder = context.getExternalFilesDir(null).getAbsolutePath() +"/."+Params.EmailId+"/"+oldDbName;
            String new_storage_folder=context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+newDbName;
            File sourceFile = new File(storage_folder);
            File destFile = new File(new_storage_folder);

            //Now rename subfiles
            String oldsource1 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+oldDbName+"/"+oldDbName;
            String newdest1 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+oldDbName+"/"+newDbName;
//            File dir = new File(storage_folder);
            File oldsourcef1 = new File(oldsource1);
            File newdestf1 = new File(newdest1);
            if (oldsourcef1.renameTo(newdestf1)) {//Directory Name changed
                System.out.println("Directory renamed successfully");
            } else {
                System.out.println("Failed to rename directory");
            }

            String oldsource2 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+oldDbName+"/"+oldDbName+"-wal";
            String newdest2 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+oldDbName+"/"+newDbName+"-wal";
            String oldsource3 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+oldDbName+"/"+oldDbName+"-shm";
            String newdest3 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+oldDbName+"/"+newDbName+"-shm";

            File oldsourcef2 = new File(oldsource2);
            File newdestf2 = new File(newdest2);
            File oldsourcef3 = new File(oldsource3);
            File newdestf3 = new File(newdest3);
            oldsourcef2.renameTo(newdestf2);
            oldsourcef3.renameTo(newdestf3);

            //Now delete main directory of these sub files
            if (sourceFile.renameTo(destFile)) {//Directory Name changed
                System.out.println("Directory renamed successfully");
            } else {
                System.out.println("Failed to rename directory");
            }


            //Log.d("dbsvm","new config table name "+newDbName);
//            Params.Curent_Running_Db=newDbName;
//            Params.DB_NAME=newDbName;

        }
        catch (Exception e)
        {
            Log.d("dbsvm","Unable to change CustomerGroup db name\n" +
                    "Error : "+e.getMessage().toString());
        }
//
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void deleteCustomeGroupDatabaseFromStoringTable(String dbName) {
        //Need to run adn debug
        try {
            SQLiteDatabase db = this.getWritableDatabase();
//            db.execSQL("delete from " + Params.TABLE_NAME+" where "+Params.DATE+"="+Contact.selectedDate);
//            db.execSQL("DROP TABLE IF EXISTS "+Params.TABLE_NAME);//Table deleted
//            SQLiteDatabase db = this.getWritableDatabase();
//            db.update(Params.ToStoreCustomerGroupsDatabase, Params.CustomerGroupCreatedDatabaseName +"=?", new String[]{String.valueOf(dbName)});
            db.delete(Params.ToStoreCustomerGroupsDatabase, Params.CustomerGroupCreatedDatabaseName +"=?", new String[]{String.valueOf(dbName)});
            //Log.d("dbsvm", "CustomerGroupTable deleted");
//            db.execSQL("DROP DATABASE "+dbName);//Delete all table associated with passed dbName
//            db.execSQL("DROP TABLE IF EXISTS "+Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE);
//            //Now delete other associated tables with it
//            db.execSQL("DROP TABLE IF EXISTS "+Params.TABLE_NAME);//Table deleted
//            db.execSQL("DROP TABLE IF EXISTS "+Params.DEFAULT_DATA_TABLE_NAME);//Table deleted
//            db.execSQL("DROP TABLE IF EXISTS "+Params.DEFAULT_CUSTOMER_NAMES_TABLE);//Table deleted
//            //Log.d("dbsvm","CustomerGroup table deleted along with " +
//                    "three other tables associated with it\n" +
//                    "Main, DefaultMilk value, Default customers");



            db.close();
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Error in deleting table CustomerGroupTable :"+e.getMessage().toString());
        }
    }

    public void dropGroupTablesAssociated(String dbName)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DROP TABLE IF EXISTS "+Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE);
//    db.execSQL("DROP DATABASE "+dbName);//Delete all table associated with passed dbName

    }
    public int isCustomerDatabaseDataRowExist() {

        SQLiteDatabase db = getWritableDatabase();
        String selectString = "SELECT * FROM " + Params.ToStoreCustomerGroupsDatabase;

        // Add the String you are searching by here.
        // Put it in an array to avoid an unrecognized token error
        Cursor cursor = db.rawQuery(selectString, null);

//        boolean hasObject = false;
        int flag=0;//does not exist
        if(cursor.moveToFirst()){
//            hasObject = true;
            flag=1;
            //region if you had multiple records to check for, use this region.

            int count = 0;
            while(cursor.moveToNext()){
                count++;
            }
            //here, count is records found
//            //Log.d("dbsvm", String.format("%d records found", count));

            //endregion

        }

        cursor.close();          // Dont forget to close your cursor
        db.close();              //AND your Database!
        return flag;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<String> getAllSavedCustomerGroupDatabaseNames(){
        ArrayList<String> contactList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        //Generate the query to read from database
        String select="SELECT * FROM "+Params.ToStoreCustomerGroupsDatabase;
//        String select="SELECT * FROM "+Params.DEFAULT_DATA_TABLE_NAME;

        Cursor cursor=db.rawQuery(select,null);
        //Loop through now
        if(cursor.moveToFirst())
        {
            do{
//                CustomerGroupDatabases contact=new CustomerGroupDatabases();
                String contact;
                contact=cursor.getString(0);

                contactList.add(contact);
            }while (cursor.moveToNext());
            //Log.d("dbsvm","fetching database name storing table data");
        }
        //Log.d("dbsvm","fetched database name storing table data");

        return contactList;
    }

    public void deleteCustomerGroup()//Working fine group name deleted successfully
    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        String storage_folder = context.getExternalFilesDir(null).getAbsolutePath()+"/."+Params.EmailId+"/"+Params.DB_NAME;
        String path = context.getExternalFilesDir(null).getAbsolutePath()
                +"/."+Params.EmailId+"/"+Params.DB_NAME;
//        File dir = new File(storage_folder);
        File file = new File(path);

        if (file.exists()) {
            String deleteCmd = "rm -r " + path;
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(deleteCmd);
            } catch (IOException e) {
                Log.d("dbsvm","\nUnable to delete customer group\n"+
                        "Error:" +e.getMessage().toString());
            }
        }

//        if (dir.isDirectory())
//        {
//            String[] children = dir.list();
//            for (int i = 0; i < children.length; i++)
//            {
//                new File(dir, children[i]).delete();
//                //Log.d("dbsvm",+i+" th file deleted");
//            }
//                dir.delete();
//        }
//        db.execSQL("DROP DATABASE "+Params.DB_NAME);//Delete all table associated with passed dbName

    }

    public void createConfigureCustomerGroupDataTableWithMonthAndYear(SQLiteDatabase db)
    {
        try {
            String create = "CREATE TABLE IF NOT EXISTS " + Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE + "(" +
                    Params.SubTableNameWithMonthAndYearToConfigureCustomerGroupNewData + " VARCHAR(15) PRIMARY KEY" + ")";

            //Log.d("dbsvm", "Query being run :\n " + create);
            db.execSQL(create);
            //Log.d("dbsvm", "\n    CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR\n Table created successfully");

//            db.execSQL("DROP TABLE IF EXISTS "+Params.TABLE_NAME);
//                   //Log.d("dbsvm"," Main contacts_db table dropped");
//
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","ConfigureCustomerGroupDataWithMonthAndYear "+e.getMessage().toString());
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
//public void addContact()
    public void insertConfigureCustomerGroupDataWithMonthAndYear(String newTableName)
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
//            values.put(Params.C1, contact.getC1());
//            values.put(Params.C2, contact.getC2());

            values.put(Params.SubTableNameWithMonthAndYearToConfigureCustomerGroupNewData,newTableName);
//            //Log.d("sk", "Successfully inserted");


            db.insert(Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE, null, values);
            //Log.d("dbsvm", "CustomerGroupTable Successfully inserted");
            db.close();

            //notify caller (class) that data is being inserted
            //flag is returned to handle alertBoxes, to show msg to user
            //if tries to insert data with the exiting date in database

//            GetAlerts ga=new GetAlerts();
//            ga.alertDialogBox(null, "Date : "+contact.getDATE() + "  record inserted", "Record Inserted");

        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Unbale to insert Customer Group Table, Error: "+e.getMessage().toString());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateConfigureCustomerGroupDataTableWithMonthAndYear(String oldName,String newDbName)
    //Need to run and debug
    {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
//            values.put(Params.C1, contact.getC1());
//            values.put(Params.C2, contact.getC2());

            values.put(Params.SubTableNameWithMonthAndYearToConfigureCustomerGroupNewData,newDbName);
//            //Log.d("sk", "Successfully inserted");

//            db.update(Params.ToStoreCustomerGroupsDatabase, values, Params.CustomerGroupCreatedDatabaseName + "=?" ,
//                    new String[]{String.valueOf(newDbName)});
            db.update(Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE, values, Params.SubTableNameWithMonthAndYearToConfigureCustomerGroupNewData + "=?" ,
                    new String[]{String.valueOf(oldName)});

//            db.execSQL("Attach "+Params.DB_NAME+" AS "+" newDbName;");
//            db.update(Params.TABLE_NAME, values, "date = ?",null);

//            db.insert(Params.TABLE_NAME, null, values);
            //Log.d("dbsvm", "ConfigureCustomerGroupDataWithMonthAndYearSuccessfully updated");
            db.close();
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Unbale to update createConfigureCustomerGroupDataWithMonthAndYear, Error: "+e.getMessage().toString());
        }
    }




    public int isConfigureCustomerGroupDataTableWithMonthAndYearRowExist() {

        SQLiteDatabase db = getWritableDatabase();
        String selectString = "SELECT * FROM " + Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE;

        // Add the String you are searching by here.
        // Put it in an array to avoid an unrecognized token error
        Cursor cursor = db.rawQuery(selectString, null);

//        boolean hasObject = false;
        int flag=0;//does not exist
        if(cursor.moveToFirst()){
//            hasObject = true;
            flag=1;
            //region if you had multiple records to check for, use this region.

            int count = 0;
            while(cursor.moveToNext()){
                count++;
            }
            //here, count is records found
//            //Log.d("dbsvm", String.format("%d records found", count));

            //endregion

        }

        cursor.close();          // Dont forget to close your cursor
        db.close();              //AND your Database!
        return flag;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void deleteConfigureCustomerGroupWithMonthAndYear(String dbName) {
        //Need to run adn debug
        try {
            SQLiteDatabase db = this.getWritableDatabase();
//            db.execSQL("delete from " + Params.TABLE_NAME+" where "+Params.DATE+"="+Contact.selectedDate);
//            db.execSQL("DROP TABLE IF EXISTS "+Params.TABLE_NAME);//Table deleted
//            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE, Params.SubTableNameWithMonthAndYearToConfigureCustomerGroupNewData +"=?", new String[]{String.valueOf(dbName)});
            //Log.d("dbsvm", "CustomerGroupTable deleted");

//            db.execSQL("DROP DATABASE "+dbName);//Delete all table associated with passed dbName
            //Now delete other associated tables with it
//            db.execSQL("DROP TABLE IF EXISTS "+Params.TABLE_NAME);//Table deleted
//            db.execSQL("DROP TABLE IF EXISTS "+Params.DEFAULT_DATA_TABLE_NAME);//Table deleted
//            db.execSQL("DROP TABLE IF EXISTS "+Params.DEFAULT_CUSTOMER_NAMES_TABLE);//Table deleted
//            //Log.d("dbsvm","CustomerGroup table deleted along with " +
//                    "three other tables associated with it\n" +
//                    "Main, DefaultMilk value, Default customers");



            db.close();
        }
        catch (Exception e)
        {
            //Log.d("dbsvm","Error in deleting table CustomerGroupTable :"+e.getMessage().toString());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<String> getAllSavedConfigureCustomerGroupDataTableWithMonthAndYear(){
        ArrayList<String> contactList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        //Generate the query to read from database
        String select="SELECT * FROM "+Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE;
//        String select="SELECT * FROM "+Params.DEFAULT_DATA_TABLE_NAME;

        Cursor cursor=db.rawQuery(select,null);
        //Loop through now
        if(cursor.moveToFirst())
        {
            do{
//                CustomerGroupDatabases contact=new CustomerGroupDatabases();
                String contact;
                contact=cursor.getString(0);

                contactList.add(contact);
            }while (cursor.moveToNext());
            //Log.d("dbsvm","fetching database name storing table data");
        }
        //Log.d("dbsvm","fetched database name storing table data");

        return contactList;
    }

    public void changeConfigTableNames(String newconfigurationWithMonthAndYearTable)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("ALTER TABLE "+Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE+" RENAME TO "+newconfigurationWithMonthAndYearTable);

//        db.execSQL("ALTER TABLE "+Params.TABLE_NAME+" RENAME TO "+tableName);
        db.close();
    }
//    public void changeDataAssociatdTablesWithConfig(String newdataTableName,String newdefaultDataTable,String newdefaultCustomerTable)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("ALTER TABLE "+Params.DATA_TABLE_NAME+" RENAME TO "+newdataTableName);
//        db.execSQL("ALTER TABLE "+Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE+" RENAME TO "+newdefaultDataTable);
//        db.execSQL("ALTER TABLE "+Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE+" RENAME TO "+newdefaultCustomerTable);
//
////        db.execSQL("ALTER TABLE "+Params.TABLE_NAME+" RENAME TO "+tableName);
//        db.close();
//    }

//    public void deleteAllTables()
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
////        db.execSQL("DROP TABLE IF EXISTS "+Params.DATA_TABLE_NAME);
////        db.execSQL("DROP TABLE IF EXISTS "+Params.DEFAULT_DATA_TABLE_NAME);
////        db.execSQL("DROP TABLE IF EXISTS "+Params.DEFAULT_CUSTOMER_NAMES_TABLE);
//        db.execSQL("DROP TABLE IF EXISTS "+Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE);
//
//        db.close();
//    }

    public  void changeCustomerGroupConfigName(String oldDbName,String newDbName)
    {
        try {



            String storage_folder = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+Params.CURRENT_GROUP_DB_NAME+"/"+oldDbName.replace("  "," ");
            String new_storage_folder=context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+Params.CURRENT_GROUP_DB_NAME+"/"+newDbName;
            File sourceFile = new File(storage_folder);
            File destFile = new File(new_storage_folder);
            //Log.d("dbsvm","\nConfig old storage folder: "+storage_folder);
            //Log.d("dbsvm","\nConfig new storage folder: "+new_storage_folder);
//
            //Now rename subfiles
            String oldsource1 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+Params.CURRENT_GROUP_DB_NAME+"/"+oldDbName+"/"+oldDbName;
            String newdest1 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+Params.CURRENT_GROUP_DB_NAME+"/"+oldDbName+"/"+newDbName;
//            File dir = new File(storage_folder);
            File oldsourcef1 = new File(oldsource1);
            File newdestf1 = new File(newdest1);
            if (oldsourcef1.renameTo(newdestf1)) {//Directory file Name changed
                //Log.d("dbsvm","file renamed successfully");

            } else {

                //Log.d("dbsvm","Unable  to rename file");
            }

            String oldsource2 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+Params.CURRENT_GROUP_DB_NAME+"/"+oldDbName+"/"+oldDbName+"-wal";
            String newdest2 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+Params.CURRENT_GROUP_DB_NAME+"/"+oldDbName+"/"+newDbName+"-wal";
            String oldsource3 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+Params.CURRENT_GROUP_DB_NAME+"/"+oldDbName+"/"+oldDbName+"-shm";
            String newdest3 = context.getExternalFilesDir(null).getAbsolutePath()
                    +"/."+Params.EmailId+"/"+Params.CURRENT_GROUP_DB_NAME+"/"+oldDbName+"/"+newDbName+"-shm";

            File oldsourcef2 = new File(oldsource2);
            File newdestf2 = new File(newdest2);
            File oldsourcef3 = new File(oldsource3);
            File newdestf3 = new File(newdest3);
            oldsourcef2.renameTo(newdestf2);
            oldsourcef3.renameTo(newdestf3);

            //Now delete main directory of these sub files
            if(sourceFile.exists()) {
                //Log.d("dbsvm", sourceFile + " dir exists");
            }
            else
            {
                //Log.d("dbsvm",sourceFile+" dir does not exists");
                sourceFile.mkdirs();

            }

            if (sourceFile.renameTo(destFile)) {//Directory Name changed
                //Log.d("dbsvm","Directory renamed successfully");
            } else {
                //Log.d("dbsvm","\nunable to rename directory");
            }


            //Log.d("dbsvm","new config db name "+newDbName);
//            Params.Curent_Running_Db=newDbName;
//            Params.DB_NAME=newDbName;

        }
        catch (Exception e)
        {
            Log.d("dbsvm","Unable to change CustomerGroup db name\n" +
                    "Error : "+e.getMessage().toString());
        }
//
    }

    public int isCustomerGroupConfigDatabaseExist(String tableName) {

        SQLiteDatabase db = getWritableDatabase();
        String selectString = "SELECT * FROM " + Params.CONFIGURE_CUSTOMER_GROUP_DATA_WITH_MONTH_AND_YEAR_TABLE + " WHERE " + Params.SubTableNameWithMonthAndYearToConfigureCustomerGroupNewData + " =?";

        // Add the String you are searching by here.
        // Put it in an array to avoid an unrecognized token error
        Cursor cursor = db.rawQuery(selectString, new String[] {tableName});

//        boolean hasObject = false;
        int flag=0;//does not exist
        if(cursor.moveToFirst()){
//            hasObject = true;
            flag=1;
            //region if you had multiple records to check for, use this region.

            int count = 0;
            while(cursor.moveToNext()){
                count++;
            }
            //here, count is records found
            //Log.d("dbsvm", String.format("%d records found", count));

            //endregion

        }

        cursor.close();          // Dont forget to close your cursor
        db.close();              //AND your Database!
        return flag;
    }




}
