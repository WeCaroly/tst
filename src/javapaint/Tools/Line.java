/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapaint.Tools;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.util.ArrayList;
import javapaint.CreateInput;

/**
 *
 * @author carol_8wybosj
 */
public class Line extends Tools{

    @Override
    public void clear() {
        shapes.clear();
        color.clear();
    }

    @Override
    protected ArrayList<Color> getArrayColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public class PointPair
    {
        Point left;
        Point right;
        
        public PointPair(Point l, Point r)
        {
            left = l;
            right = r;
        }
    }
    
    private ArrayList<PointPair> shapes = new ArrayList<PointPair>();
    private ArrayList<Color> color = new ArrayList<Color>();
    public Point str = new Point(0, 0), end = new Point(0, 0);    
    private Point point = new Point(0, 0);
    private CreateInput mouse;
     
  public Line(Canvas canvas){
    mouse = new CreateInput(canvas);
  }     
      
    //TODO: How do i save this shape into a arrayList?
    public void draw(Graphics g, int code,Point str,Point end, boolean b, CreateInput mouse){ 
        if(str.x == 0){
            str = mouse.getPosition();
        }
            
        
        if(code == 1){ // line
            shapes.add(new PointPair(str, point));
            color.add(g.getColor());
            
        }else{ //poly
            shapes.add(new PointPair(str, point));
            color.add(g.getColor());
        }
        
        if(!b){
            color.add(g.getColor());
            shapes.add(new PointPair(str, end));
        }
        
    }
 
    public void AddShapes(Graphics g){
    for (int i = 0; i < shapes.size() - 1; i++){
            // Adding a null into the list is used
            // for breaking up the lines when
            // there are two or more lines
            // that are not connected
            if (!(shapes == null) && color.get(i)!=null) {
                g.setColor(color.get(i));
                g.drawLine(shapes.get(i).left.x, shapes.get(i).left.y, 
                        shapes.get(i).right.x, shapes.get(i).right.y);
                
            }
        }
    }

}
