package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.factories.RectangleFactory;
import edu.kis.powp.jobs2d.factories.TriangleFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestTriangleDrawListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestTriangleDrawListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		TriangleFactory factory = new TriangleFactory(driverManager.getCurrentDriver(), -120, -120, 80);
		edu.kis.powp.commands.ComplexCommand command =  factory.create();

		command.execute();
	}
}
