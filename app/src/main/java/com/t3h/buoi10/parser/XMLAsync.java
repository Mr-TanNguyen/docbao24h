package com.t3h.buoi10.parser;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.t3h.buoi10.model.News;

import org.xml.sax.SAXException;

import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by admin on 5/19/2018.
 */

public class XMLAsync extends AsyncTask<String, Void, ArrayList<News>> {
    public static final int WHAT_DATA = 1;
    private Handler handler;

    public XMLAsync(Handler handler) {
        this.handler = handler;
    }

    @Override
    protected ArrayList<News> doInBackground(String... strings) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            String link = strings[0];
            parser.parse(link, handler);
            return handler.getArrNews();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(ArrayList<News> news) {
        super.onPostExecute(news);
        Message message = new Message();
        message.what = WHAT_DATA;
        message.obj = news;
        handler.sendMessage(message);
    }
}
