package com.in28minutes.rest.webservices.restfulwebservices;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ZetaReport {
	private File fileObj = null;
	
	public static String projDir = "";
	private BufferedWriter bufferedWriter = null;
	private StringBuilder stringBuilder = null;
	private String respFileNameString = "", theJsonPath = "", replaceString = "";
	private int counterPass = 0, counterFail = 0;

	public void createReport(ArrayList<Result> String ) throws Exception {
		fileObj = new File("TestReport.html");
		bufferedWriter = new BufferedWriter(new FileWriter(fileObj));
		bufferedWriter.write("<html><body><h1>Test Case Result!</h1>");
		
		bufferedWriter.write("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>" + "<style>\r\n" + "table {\r\n"
				+ "  font-family: arial, sans-serif;\r\n" + "  border-collapse: collapse;\r\n" + "  width: 100%;\r\n"
				+ "}\r\n" + "\r\n" + "td, th {\r\n" + "  border: 1px solid #dddddd;\r\n" + "  text-align: left;\r\n"
				+ "  padding: 8px;\r\n" + "}\r\n" + "\r\n" + "tr:nth-child(even) {\r\n"
				+ "  background-color: #dddddd;\r\n" + "}\r\n" + "</style>\r\n" + "</head>\r\n" + "<body>\r\n" + "\r\n"
				+ "<table><tr><td><div id=\"piechart\"></div></td><td><div id=\"barchart\"></td></div><table><tr>\r\n"
				+ "    <th>TestCaseId</th>\r\n" +  "<th>Test Name</th>\r\n" +  "    <th>TestCase Description</th>\r\n"
				+ "    <th>Status</th>\r\n" + "  </tr>");
		for (int currentRow = 0; currentRow <String.size(); currentRow++) {
			 String status="";
			if (!"Pass".equalsIgnoreCase(String.get(currentRow).getStatus())) {
				counterFail = counterFail + 1;
			status="Fail";
			} else {
				counterPass = counterPass + 1;
				status="Pass";
			}
			//respFileName = row.getCell(ACT_RES_FILENAME);
			//respFileNameString = formatter.formatCellValue(respFileName);
			stringBuilder = new StringBuilder(respFileNameString);
			while (stringBuilder.length() > 0 && stringBuilder.charAt(0) == '.') {
				stringBuilder.deleteCharAt(0);
			}
			replaceString = stringBuilder.toString().replace('/', '\\');
			
			bufferedWriter.write("<tr>\r\n" + "<td>" + currentRow + "</td>\r\n" + "    <td>"
					+ String.get(currentRow).getTestCaseName() + "</td>\r\n" + " \r\n" + "    <td>"
					+ String.get(currentRow).getResponse() + "</td>\r\n" + " \r\n" +"    <td>"
					+ status + "</td>\r\n" + "</tr>\r\n");
		}		
		bufferedWriter.write("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n"
						+ "<script type=\"text/javascript\">\r\n" + "// Load google charts\r\n"
						+ "google.charts.load('current', {'packages':['corechart']});\r\n"
						+ "google.charts.setOnLoadCallback(drawChart);\r\n" + "\r\n"
						+ "// Draw the chart and set the chart values\r\n" + "function drawChart() {\r\n"
						+ "  var data = google.visualization.arrayToDataTable([\r\n"
						+ "[\"Element\", \"Density\", { role: \"style\" } ],\r\n" + "        [\"Pass Cases "
						+ counterPass + "\", " + counterPass + ", \"##3366cc\"],\r\n" + "        [\"Fail Cases "
						+ counterFail + "\", " + counterFail + ", \"#dc3912\"]\r\n" + "      ]);\r\n" + "\r\n"
						+ "  // Optional; add a title and set the width and height of the chart\r\n"
						+ "  var options = {'title':'Test Cases', 'width':550, 'height':400,is3D:true};\r\n" + "\r\n"
						+ "  // Display the chart inside the <div> element with id=\"piechart\"\r\n"
						+ "  var chart = new google.visualization.PieChart(document.getElementById('piechart'));\r\n"
						+ "  chart.draw(data, options);\r\n"
						+ "  var chart = new google.visualization.BarChart(document.getElementById('barchart'));\r\n"
						+ "  chart.draw(data, options);\r\n" + "}\r\n" + "</script>");
		bufferedWriter.write("</table>\r\n");
		bufferedWriter.write("</body></html>");
		bufferedWriter.write(fileObj.getAbsolutePath());
		bufferedWriter.close();
	//	Desktop.getDesktop().browse(fileObj.toURI());
	}
	public void createReportFail(ArrayList<Result> String ) throws Exception {
		fileObj = new File("TestReportFail.html");
		bufferedWriter = new BufferedWriter(new FileWriter(fileObj));
		bufferedWriter.write("<html><body><h1>Test Case Result!</h1>");
		
		bufferedWriter.write("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>" + "<style>\r\n" + "table {\r\n"
				+ "  font-family: arial, sans-serif;\r\n" + "  border-collapse: collapse;\r\n" + "  width: 100%;\r\n"
				+ "}\r\n" + "\r\n" + "td, th {\r\n" + "  border: 1px solid #dddddd;\r\n" + "  text-align: left;\r\n"
				+ "  padding: 8px;\r\n" + "}\r\n" + "\r\n" + "tr:nth-child(even) {\r\n"
				+ "  background-color: #dddddd;\r\n" + "}\r\n" + "</style>\r\n" + "</head>\r\n" + "<body>\r\n" + "\r\n"
				+ "<table><tr><td><div id=\"piechart\"></div></td><td><div id=\"barchart\"></td></div><table><tr>\r\n"
				+ "    <th>TestCaseId</th>\r\n" +  "<th>Test Name</th>\r\n" +  "    <th>TestCase Description</th>\r\n"
				+ "    <th>Status</th>\r\n" + "  </tr>");
		for (int currentRow = 0; currentRow <String.size(); currentRow++) {
			 String status="";
			if (!"Pass".equalsIgnoreCase(String.get(currentRow).getStatus())) {
				counterFail = counterFail + 1;
			status="Fail";
			} else {
				counterPass = counterPass + 1;
				status="Pass";
			}
			//respFileName = row.getCell(ACT_RES_FILENAME);
			//respFileNameString = formatter.formatCellValue(respFileName);
			stringBuilder = new StringBuilder(respFileNameString);
			while (stringBuilder.length() > 0 && stringBuilder.charAt(0) == '.') {
				stringBuilder.deleteCharAt(0);
			}
			replaceString = stringBuilder.toString().replace('/', '\\');
			
			bufferedWriter.write("<tr>\r\n" + "<td>" + currentRow + "</td>\r\n" + "    <td>"
					+ String.get(currentRow).getTestCaseName() + "</td>\r\n" + " \r\n" + "    <td>"
					+ String.get(currentRow).getResponse() + "</td>\r\n" + " \r\n" +"    <td>"
					+ status + "</td>\r\n" + "</tr>\r\n");
		}		
		bufferedWriter.write("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n"
						+ "<script type=\"text/javascript\">\r\n" + "// Load google charts\r\n"
						+ "google.charts.load('current', {'packages':['corechart']});\r\n"
						+ "google.charts.setOnLoadCallback(drawChart);\r\n" + "\r\n"
						+ "// Draw the chart and set the chart values\r\n" + "function drawChart() {\r\n"
						+ "  var data = google.visualization.arrayToDataTable([\r\n"
						+ "[\"Element\", \"Density\", { role: \"style\" } ],\r\n" + "        [\"Pass Cases "
						+ counterPass + "\", " + counterPass + ", \"##3366cc\"],\r\n" + "        [\"Fail Cases "
						+ counterFail + "\", " + counterFail + ", \"#dc3912\"]\r\n" + "      ]);\r\n" + "\r\n"
						+ "  // Optional; add a title and set the width and height of the chart\r\n"
						+ "  var options = {'title':'Test Cases', 'width':550, 'height':400,is3D:true};\r\n" + "\r\n"
						+ "  // Display the chart inside the <div> element with id=\"piechart\"\r\n"
						+ "  var chart = new google.visualization.PieChart(document.getElementById('piechart'));\r\n"
						+ "  chart.draw(data, options);\r\n"
						+ "  var chart = new google.visualization.BarChart(document.getElementById('barchart'));\r\n"
						+ "  chart.draw(data, options);\r\n" + "}\r\n" + "</script>");
		bufferedWriter.write("</table>\r\n");
		bufferedWriter.write("</body></html>");
		bufferedWriter.write(fileObj.getAbsolutePath());
		bufferedWriter.close();
	//	Desktop.getDesktop().browse(fileObj.toURI());
	}
}
