
package fr.ubo.m2tiil.louarn.demo.graphicLayer.demos;

import fr.ubo.m2tiil.louarn.demo.graphicLayer.Oval;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import fr.ubo.m2tiil.louarn.demo.graphicLayer.Morph;
import fr.ubo.m2tiil.louarn.demo.graphicLayer.World;

public class Example1 {

	public static void main(String[] args) {
		Random x = new Random();
		World jc = new World("Un essai de Morphs");
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(800, 600));
		Dimension dim = new Dimension(5, 5);
		for (int i = 0; i < 20000; i++) {
			dim = new Dimension(x.nextInt(20), x.nextInt(20));
			jc.add(new Oval(new Color((int) (Math.random() * 0x1000000)), new Point(0, 0), dim));
		}
		jc.open();
		while (true) {
			List<Morph> drawables = jc.contents();
			for (Iterator<Morph> iter = drawables.iterator(); iter.hasNext();) {
				iter.next().setPosition(new Point(x.nextInt(800), x.nextInt(600)));
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
