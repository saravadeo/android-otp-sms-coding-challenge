package com.example.osarvade.kisannetwork.dummy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static final List<DummyDetails> ITEMS1 = new ArrayList<DummyDetails>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();
    public static final Map<String, DummyDetails> ITEM_MAP_DETAILS = new HashMap<String, DummyDetails>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
      /*  for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }*/
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static void addDetails(DummyDetails item) {
        ITEMS1.add(item);
        ITEM_MAP_DETAILS.put(item.id, item);
    }

    public static void fillData(String json,int flag) {

        if(flag==0) {

            try {


                JSONObject jsonRootObject = new JSONObject(json);

                //Get the instance of JSONArray that contains JSONObjects
                JSONArray jsonArray = jsonRootObject.optJSONArray("contacts");

                //Iterate the jsonArray and print the info of JSONObjects
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String id = jsonObject.optString("id").toString();
                    String name = jsonObject.optString("name").toString();


                    addItem(new DummyItem(id, name));


                }

                Collections.sort(ITEMS);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else
        {
            try {


                JSONObject jsonRootObject = new JSONObject(json);

                //Get the instance of JSONArray that contains JSONObjects
                JSONArray jsonArray = jsonRootObject.optJSONArray("contactsDetails");

                //Iterate the jsonArray and print the info of JSONObjects
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String id = jsonObject.optString("id").toString();
                    String name = jsonObject.optString("name").toString();
                    String mbnumber = jsonObject.optString("mobileNo").toString();
                    String emailId = jsonObject.optString("emailId").toString();


                    addDetails(new DummyDetails(id, name,mbnumber,emailId));


                }

                Collections.sort(ITEMS);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem implements Comparable{
        public final String id;
        public final String name;


        public DummyItem(String id, String name) {
            this.id = id;
            this.name = name;

        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }





        @Override
        public int compareTo(Object another) {
            String name=((DummyItem)another).getName();

            return this.name.compareTo(name);
        }
    }

    public static class DummyDetails{
        public final String id;
        public final String name;
        public final String mbnumber;
        public final String emialID;


        public DummyDetails(String id, String name,String mbnumber,String emialID) {
            this.id = id;
            this.name = name;
            this.mbnumber=mbnumber;
            this.emialID=emialID;

        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }


        public String getMbnumber() {
            return mbnumber;
        }

        public String getEmialID() {
            return emialID;
        }


    }
}
