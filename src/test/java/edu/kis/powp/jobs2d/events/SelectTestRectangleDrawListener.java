package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.factories.RectangleFactory;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestRectangleDrawListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestRectangleDrawListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		RectangleFactory factory = new RectangleFactory(driverManager.getCurrentDriver(), -120, -120, 80, 60);
		edu.kis.powp.commands.ComplexCommand command =  factory.create();

		command.execute();
	}
}
