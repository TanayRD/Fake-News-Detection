/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawler.scrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class WebCrawlerScrapper {
    public static int count=0,pgnxt=2;
    public static ResultSet rs,rs1,rs3;
    public static String query;
    public static String next_url;

    public static dbconnection db=new dbconnection();
    public static dbconnection db1=new dbconnection();
    public static dbconnection db2=new dbconnection();
    public static void getCities(String url)
    {
            
            
            try {
            
            Document doc=Jsoup.connect(url).get();
            Elements links=doc.select("a[href]");
            for(Element link:links)
            {
                if(link.attr("href").contains("https://indianexpress.com/article/cities/"))
                {
                    //System.out.println(link.attr("abs:href"));
                    enterLink(link.attr("href"),"citieslinks");              
                }
                
            }
          //next page 
//          Elements list = doc.select("ul.pagination>ul.page-numbers");
//          Element current=list.select("li:eq("+pgnxt+") >a").first();
//          //Element next=current.nextElementSibling();
          next_url="https://indianexpress.com/section/cities/page/"+pgnxt+"/";
          pgnxt++;
//          System.out.println(current.attr("href"));
//          int i=0;
//          for(Element link:links)
//            {
//                next_url=link.attr("href");
//                System.out.println(next_url);
//                i++;
//                if(i==3)
//                    break;
//                
//            }
          
          rs1=db.dql("select count(*) from citieslinks");
          rs1.next();
          count=rs1.getInt(1);
          if (next_url!=null && count<=1000 )
            getCities(next_url);
          else
              System.out.println("Finished.");
          
        } catch(IOException ex){
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }  
            
    }
    
    public static void getEntertain(String url)
    {
            
            try {
            
            Document doc=Jsoup.connect(url).get();
            Elements links=doc.select("a[href]");
            for(Element link:links)
            {
                if(link.attr("href").contains("https://indianexpress.com/article/entertainment/"))
                {
                    //System.out.println(link.attr("abs:href"));
                    enterLink(link.attr("href"),"entertainmentlinks");              
                }
                
            }
          //next page 
//          Elements list = doc.select("ul.pagination>ul.page-numbers");
//          Element current=list.select("li:eq("+pgnxt+") >a").first();
//          //Element next=current.nextElementSibling();
          next_url="https://indianexpress.com/section/entertainment/page/"+pgnxt+"/";
          pgnxt++;
//          System.out.println(current.attr("href"));
//          int i=0;
//          for(Element link:links)
//            {
//                next_url=link.attr("href");
//                System.out.println(next_url);
//                i++;
//                if(i==3)
//                    break;
//                
//            }
          
          rs1=db.dql("select count(*) from entertainmentlinks");
          rs1.next();
          count=rs1.getInt(1);
          if (next_url!=null && count<=1000 )
            getEntertain(next_url);
          else
              System.out.println("Finished.");
          
        } catch(IOException ex){
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    public static void getTech(String url)
    {
      try {
            
            Document doc=Jsoup.connect(url).get();
            Elements links=doc.select("a[href]");
            for(Element link:links)
            {
                if(link.attr("href").contains("https://indianexpress.com/article/technology/"))
                {
                    //System.out.println(link.attr("abs:href"));
                    enterLink(link.attr("href"),"techlinks");              
                }
                
            }
          //next page 
//          Elements list = doc.select("ul.pagination>ul.page-numbers");
//          Element current=list.select("li:eq("+pgnxt+") >a").first();
//          //Element next=current.nextElementSibling();
          next_url="https://indianexpress.com/section/technology/page/"+pgnxt+"/";
          pgnxt++;
//          System.out.println(current.attr("href"));
//          int i=0;
//          for(Element link:links)
//            {
//                next_url=link.attr("href");
//                System.out.println(next_url);
//                i++;
//                if(i==3)
//                    break;
//                
//            }
          
          rs1=db.dql("select count(*) from techlinks");
          rs1.next();
          count=rs1.getInt(1);
          if (next_url!=null && count<=1000 )
            getTech(next_url);
          else
              System.out.println("Finished.");
          
        } catch(IOException ex){
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    
    public static void getLifestyle(String url)
    {
       try {
            
            Document doc=Jsoup.connect(url).get();
            Elements links=doc.select("a[href]");
            for(Element link:links)
            {
                if(link.attr("href").contains("https://indianexpress.com/article/lifestyle/"))
                {
                    //System.out.println(link.attr("abs:href"));
                    enterLink(link.attr("href"),"lifestylelinks");              
                }
                
            }
     
          next_url="https://indianexpress.com/section/lifestyle/page/"+pgnxt+"/";
          pgnxt++;

          
          rs1=db.dql("select count(*) from lifestylelinks");
          rs1.next();
          count=rs1.getInt(1);
          if (next_url!=null && count<=1000 )
            getLifestyle(next_url);
          else
              System.out.println("Finished.");
          
        } catch(IOException ex){
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public static void getSports(String url)
    {
       try {
            
            Document doc=Jsoup.connect(url).get();
            Elements links=doc.select("a[href]");
            for(Element link:links)
            {
                if(link.attr("href").contains("https://indianexpress.com/article/sports/"))
                {
                    //System.out.println(link.attr("abs:href"));
                    enterLink(link.attr("href"),"sportlinks");              
                }
                
            }
     
          next_url="https://indianexpress.com/section/sports/page/"+pgnxt+"/";
          pgnxt++;

          
          rs1=db.dql("select count(*) from sportlinks");
          rs1.next();
          count=rs1.getInt(1);
          if (next_url!=null && count<=1000 )
            getSports(next_url);
          else
              System.out.println("Finished.");
          
        } catch(IOException ex){
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
    }
public static void getWorld(String url)
    {
       try {
            
            Document doc=Jsoup.connect(url).get();
            Elements links=doc.select("a[href]");
            for(Element link:links)
            {
                if(link.attr("href").contains("https://indianexpress.com/article/world/"))
                {
                    //System.out.println(link.attr("abs:href"));
                    enterLink(link.attr("href"),"worldlinks");              
                }
                
            }
     
          next_url="https://indianexpress.com/section/world/page/"+pgnxt+"/";
          pgnxt++;

          
          rs1=db.dql("select count(*) from worldlinks");
          rs1.next();
          count=rs1.getInt(1);
          if (next_url!=null && count<=1000 )
            getWorld(next_url);
          else
              System.out.println("Finished.");
          
        } catch(IOException ex){
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public static void getIndianNews(String url)
    {
            
        try {
            
            
            Document doc=Jsoup.connect(url).get();
            
            Elements links=doc.select("a[href]");
            for(Element link:links)
            {
                if(link.attr("href").contains("https://indianexpress.com/article/india/"))
                {
                    System.out.println(link.attr("abs:href"));
                    enterLink(link.attr("href"),"indialinks");              
                }
                
            }
            
          //next page 
          
          links = doc.select("a.next.page-numbers");
          for(Element link:links)
            {
                next_url=link.attr("href");
                System.out.println(next_url);
                break;
            }
          int count=0;
          rs1=db.dql("select count(*) from indialinks");
          rs1.next();
          count=rs1.getInt(1);
          if (next_url!=null && count<=1000 )
            getIndianNews(next_url);
          else
              System.out.println("Next url is empty.");
        } catch(IOException ex){
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (SQLException ex) {
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static String process(String text){
        if(text.contains("'"))
           text=text.replace("'","''");
        if(text.contains("₹"))
            text=text.replace("₹","Re.");
        return text;
    }
    public static void enterLink(String url,String table)
    {
        try {
            rs=db.dql("select * from "+table+" where url=\'"+url+"\'");
            if (rs.next())
            {
                
            }
            else{
                query="insert into "+table+"(url) values(\'"+url+"\')";
                int row=db.dml(query);
                count++;
                //System.out.println("Link inserted:"+count);
            }   } catch (SQLException ex) {
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void getLink(String url)
    {
        try {
            
            Document doc=Jsoup.connect(url).get();
            Elements links=doc.select("a[href]");
            rs1=db.dql("slect id from opinionlinks");
            int id=0;
            if(rs1.next())
                id=rs1.getInt(1);
            
            if(id>=1000)
                   return;
                for(Element link:links)
                {
                    if(link.attr("href").contains("https://indianexpress.com/article/opinion/"))
                    {
                        //System.out.println(link.attr("abs:href"));
                        enterLink(link.attr("href"),"opinionlinks");              
                    }

                }
          //next page 
          links = doc.select("a.next.page-numbers");
          for(Element link:links)
            {
                next_url=link.attr("href");
                System.out.println(next_url);
                break;
            }
          if (next_url!=null)
            getLink(next_url);
          else
              System.out.println("Next url is empty.");
        } catch(IOException ex){
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int getData(String url,int count) 
    {
            int row=0;
        try {
            Document doc=Jsoup.connect(url).get();
            Element date=doc.select("div.story-details > div.main-story > div.articles > div.full-details > div.editor > span[itemprop=dateModified]").first();
            Document doc2=Jsoup.connect(url).get();
            Element headline = doc2.select(".native_story_title").first();
            Element story = doc2.select(".synopsis").first();
            if(headline!=null&&story!=null&&date!=null)
            {
                
                
                query="Insert into fact(headline,story,category,id) values(\'"+process(headline.text())+"\',\'"+process(story.text())+"\','world',"+count+")";
               
                    row=db.dml(query);
                    if(row!=0)
                        row=db1.dml("insert into factdates values("+count+",\'"+date.text()+"\')");

                    System.out.println(row);
                    System.out.println(date.text());
                    System.out.println(story.text());
                    System.out.println(headline.text());
                
            }
            
        }catch(IOException ex){
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        
        }    
        return row;
    }

    public static void updateNum()
    {
        try {
            query="select * from fact";
            rs=db.dql(query);
            int count=1;
            while(rs.next())
            {
               System.out.println(count); 
                
                String headline=process(rs.getString(1));
                int row=db.dml("update fact set id="+count+" where headline=\'"+headline+"\'");
                System.out.println(row); 
                System.out.println("update fact set id="+count+" where headline=\'"+headline+"\'"); 
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String args[])
            
    {
         //updateNum();
    try {
    
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter Url for crawling:");
    String url=sc.next();
//    getLink(url);
//    getIndianNews(url);
//    getTech(url);
//   getCities(url);
//    getEntertain(url);
//    getLifestyle(url);
//    getSports(url);
      getWorld(url);
    rs1=db1.dql("Select count(*) from "
            + "fact");
    int count;
    int row=0;
    rs1.next();
    count=rs1.getInt(1);
    count++;
    query="select * from worldlinks";
    rs1=db.dql(query);
    try {
        while(rs1.next())
        {
            if(row!=0)
                count++;
            String url1=rs1.getString(2);
            System.out.println(url1);
            row=getData(url1,count);
//            
//            //break;
       }
//        //System.out.println(count);
    } catch (SQLException ex) {
        System.out.print(ex);
        
      
    }
    }   catch (SQLException ex) {
            Logger.getLogger(WebCrawlerScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
//> span.itemprop.dateModified