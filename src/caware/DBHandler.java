/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caware;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 12p10
 */
public class DBHandler {

    //database and table info
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cawaredb";
    private static final String TABLE_RESPONSES = "responses";

    //identifier - primary key
    private static final String KEY_ID = "id";

    //demographics
    private static final String DEM_NAME = "name";
    private static final String DEM_AGE = "age";
    private static final String DEM_SEX = "sex";
    private static final String DEM_EDU = "edu";

    //responses - each column stores a value for one response - 2 for yes, 1 for no
    private static final String QUES_1 = "QUES_1";
    private static final String QUES_2 = "QUES_2";
    private static final String QUES_3 = "QUES_3";
    private static final String QUES_4 = "QUES_4";
    private static final String QUES_5 = "QUES_5";
    private static final String QUES_6 = "QUES_6";
    private static final String QUES_7 = "QUES_7";
    private static final String QUES_8 = "QUES_8";
    private static final String QUES_9 = "QUES_9";
    private static final String QUES_10 = "QUES_10";
    private static final String QUES_11 = "QUES_11";
    private static final String QUES_12 = "QUES_12";
    private static final String QUES_13 = "QUES_13";
    private static final String QUES_14 = "QUES_14";
    private static final String QUES_15 = "QUES_15";
    private static final String QUES_16 = "QUES_16";
    private static final String QUES_17 = "QUES_17";
    private static final String QUES_18 = "QUES_18";
    private static final String QUES_19 = "QUES_19";
    private static final String QUES_20 = "QUES_20";
    private static final String QUES_21 = "QUES_21";
    private static final String QUES_22 = "QUES_22";
    private static final String QUES_23 = "QUES_23";
    private static final String QUES_24 = "QUES_24";
    private static String[] QUESTION_ARRAY;

    //create a reference to the database we are handling
    private static Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private static int counter;

    //quelle heure est-il? wie viel uhr is es?
    private String timestamp;

    public DBHandler() {

//        boolean conSuccess = false;
//        int conTryCounter = 0;
//        while (!conSuccess) {
//            conTryCounter++;
//            if (conTryCounter == 100) {
//                JOptionPane.showMessageDialog(null, "Connection to database"
//                        + " failed after 100 tries. Check errors and restart the program.");
//                break;
//
//            }
        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cawaredb", "root", "root");
            System.out.println("Database connection success.");
            statement = connection.createStatement();
            resultSet = statement.getResultSet();

            createTable();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        }

    }

    // Creating Tables
    private void createTable() {

        //create the table with relevant columns, if it already exists don't create it
        String CREATE_CONTACTS_TABLE
                = "CREATE TABLE IF NOT EXISTS " + TABLE_RESPONSES + "("
                + KEY_ID + " int(64) PRIMARY KEY AUTO_INCREMENT, " + DEM_AGE + " varchar(255),"
                + DEM_SEX + " varchar(255), " + DEM_EDU + " varchar(255), " + DEM_NAME + " varchar(255), " + QUES_1 + " varchar(255), " + QUES_2 + " varchar(255), "
                + QUES_3 + " varchar(255), " + QUES_4 + " varchar(255), " + QUES_5 + " varchar(255), " + QUES_6
                + " varchar(255), " + QUES_7 + " varchar(255), " + QUES_8 + " varchar(255), " + QUES_9 + " varchar(255), "
                + QUES_10 + " varchar(255), " + QUES_11 + " varchar(255), " + QUES_12 + " varchar(255), "
                + QUES_13 + " varchar(255), " + QUES_14 + " varchar(255), " + QUES_15 + " varchar(255), " + QUES_16
                + " varchar(255), " + QUES_17 + " varchar(255), " + QUES_18 + " varchar(255), " + QUES_19 + " varchar(255), "
                + QUES_20 + " varchar(255), " + QUES_21 + " varchar(255), " + QUES_22 + " varchar(255), "
                + QUES_23 + " varchar(255), " + QUES_24 + " varchar(255)"
                + ")";

        try {

            statement.execute(CREATE_CONTACTS_TABLE);
            System.out.println("table created");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex);

        }

    }

    public void addInfoResponse(String[] inputResponses) {

        //initialize array containing all questions
//        QUESTION_ARRAY = new String[]{DEM_AGE, DEM_SEX, DEM_EDU, DEM_NAME, QUES_1, QUES_2, QUES_3,
//            QUES_4, QUES_5, QUES_6, QUES_7, QUES_8, QUES_9, QUES_10, QUES_11, QUES_12, QUES_13,
//            QUES_14, QUES_15, QUES_16, QUES_17, QUES_18, QUES_19, QUES_20, QUES_21, QUES_22, QUES_23, QUES_24};
        String INSERT_RESPONSE = "INSERT INTO RESPONSES(AGE, SEX, EDU, NAME) "
                + "VALUES(? , ? , ? , ? )";

        try {
            PreparedStatement stmt = connection.prepareStatement(INSERT_RESPONSE);
            for (int i = 1; i < inputResponses.length + 1; i++) {

                stmt.setString(i, inputResponses[i - 1]);

            }
            System.out.println(stmt.toString());
            stmt.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void addQuestionResponse(String[] inputResponses) {

        //initialize array containing all questions
//        QUESTION_ARRAY = new String[]{DEM_AGE, DEM_SEX, DEM_EDU, DEM_NAME, QUES_1, QUES_2, QUES_3,
//            QUES_4, QUES_5, QUES_6, QUES_7, QUES_8, QUES_9, QUES_10, QUES_11, QUES_12, QUES_13,
//            QUES_14, QUES_15, QUES_16, QUES_17, QUES_18, QUES_19, QUES_20, QUES_21, QUES_22, QUES_23, QUES_24};
        String QUERY_ID = "SELECT MAX(ID) FROM RESPONSES";
        String maxID = "";

        try {

            resultSet = statement.executeQuery(QUERY_ID);
            resultSet.first();
            maxID = resultSet.getString(1);

        } catch (Exception e) {

            System.out.println("error");
        }

        String INSERT_RESPONSE = "UPDATE RESPONSES SET QUES_1 = ?, QUES_2 = ?, QUES_3 = ?,"
                + " QUES_4 = ?, QUES_5 = ?, QUES_6 = ?, QUES_7 = ?, QUES_8 = ?, QUES_9 = ?, QUES_10 = ?, QUES_11 = ?, QUES_12 = ?, QUES_13 = ?, "
                + "QUES_14 = ?, QUES_15 = ?, QUES_16 = ?, QUES_17 = ?, QUES_18 = ?, QUES_19 = ?, QUES_20 = ?, QUES_21 = ?, QUES_22 = ?, "
                + "QUES_23 = ?, QUES_24 = ? WHERE ID = " + maxID;

        try {
            PreparedStatement stmt = connection.prepareStatement(INSERT_RESPONSE);
            for (int i = 1; i < inputResponses.length + 1; i++) {

                stmt.setString(i, inputResponses[i - 1]);

            }
            System.out.println(stmt.toString());
            stmt.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

//    public void writeToCSV() {
//
//        //if you ever want to create unique exports per attempt
//        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        //timestamp = dateFormat.format(new Date());
//        File exportFolder = new File(System.
//                + File.separator + "C-Aware");
//
//        if (!exportFolder.exists()) {
//            exportFolder.mkdir();
//
//        }
//
//        File exportCSV;
//        PrintWriter writer;
//
//        try {
//
//            exportCSV = new File(exportFolder, "C-AwareDatabase.csv");
//
//            //if (!exportCSV.exists()) {
//            exportCSV.createNewFile();
//            //}
//
//            writer = new PrintWriter(new FileWriter(exportCSV));
//
//            SQLiteDatabase db = getReadableDatabase();                           //open the database for reading
//
//            Cursor curCSV = db.rawQuery("Select * from responses", null);      //feed the table to cursor
//            Log.d(null, "row count is: " + curCSV.getCount());
//
//            //write header of CSV
//            writer.println("key, age, sex, edu, name, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, "
//                    + "q15, q16, q17, q18, q19, q20, q21, q22, q23, q24");
//
//            int count = 0;
//            while (curCSV.moveToNext()) {
//
//                String record = "";
//
//                for (int i = 0; i < 28; i++) {
//                    record = record.concat(curCSV.getString(i) + ",");
//                }
//
//                record = record.concat(curCSV.getString(28));
//
//                writer.println(record);
//                count++;
//                Log.wtf(null, "value of record is:" + record);
//                Log.d(null, "" + count);
//
//            }
//
//            writer.close();
//            curCSV.close();
//            db.close();
//
//        } catch (Exception exc) {
//
//            Log.e(TAG, "writeToCSV: " + exc.toString(), null);
//            exc.printStackTrace();
//
//        }
//
//    }
}
