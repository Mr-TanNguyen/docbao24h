package com.t3h.buoi10.parser;

import com.t3h.buoi10.model.News;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by admin on 5/19/2018.
 */

public class XMLHandler extends DefaultHandler {

    private ArrayList<News> arrNews = new ArrayList<>();
    private News news;
    private final String TAG_ITEM = "item";
    private final String TAG_TITLE = "title";
    private final String TAG_DESC = "description";
    private final String TAG_DATE = "pubDate";
    private final String TAG_LINK = "link";
    private StringBuilder value;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals(TAG_ITEM)) {
            news = new News();
        }
        value = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (news == null){
            return;
        }
        switch (qName) {
            case TAG_TITLE:
                news.setTitle(value.toString());
                break;
            case TAG_DESC:
                String src = "src=\"";
                int index = value.indexOf(src);
                String desc = value.substring(index + src.length());
                index = desc.indexOf("\"");
                String img = desc.substring(0, index);
                String br = "</br>";
                index = desc.lastIndexOf(br);
                desc = desc.substring(index + br.length());
                news.setImg(img);
                news.setDesc(desc);
                break;
            case TAG_LINK:
                news.setLink(value.toString());
                break;
            case TAG_DATE:
                news.setPubDate(value.toString());
                break;
            case TAG_ITEM:
                arrNews.add(news);
                break;
        }
    }

    public ArrayList<News> getArrNews() {
        return arrNews;
    }
}
