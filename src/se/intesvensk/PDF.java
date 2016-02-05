package se.intesvensk;


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.List;

public class PDF {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PDF window = new PDF();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.BORDER |
				SWT.APPLICATION_MODAL | SWT.MIN );
		shell.setSize(1300, 650);
		shell.setText("PDF Browser");
		shell.setLayout(null);

		Label label_2 = new Label(shell, SWT.NONE);
		Label lblComingSoon = new Label(shell, SWT.NONE);
		label_2.setVisible(false);
		lblComingSoon.setVisible(false);
		
		Browser browser = new Browser(shell, SWT.NONE);
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(844, 0, 2, 631);
		
		Label lblQuickLinks = new Label(shell, SWT.NONE);
		lblQuickLinks.setToolTipText("These will affect the WebBrowser to the LEFT");
		lblQuickLinks.setBounds(854, 10, 80, 15);
		lblQuickLinks.setText("Quick Links");
		
		Button btnSteamGroupPage = new Button(shell, SWT.NONE);
		btnSteamGroupPage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("http://steamcommunity.com/groups/panaudefenseforce");
			}
		});
		btnSteamGroupPage.setBounds(852, 31, 128, 25);
		btnSteamGroupPage.setText("Steam Group Page");
		
		Button btnListOfPdf = new Button(shell, SWT.NONE);
		btnListOfPdf.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("http://steamcommunity.com/groups/panaudefenseforce#members");
			}
		});
		btnListOfPdf.setText("List of PDF Members");
		btnListOfPdf.setBounds(852, 73, 128, 25);
		
		Button btnTemplateButton = new Button(shell, SWT.NONE);
		btnTemplateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("http://jacobthewlis.wix.com/officialpdfwebsite");
			}
		});
		btnTemplateButton.setText("PDF Website");
		btnTemplateButton.setBounds(852, 117, 128, 25);
		
		Button btnJcWiki = new Button(shell, SWT.NONE);
		btnJcWiki.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("http://justcause.wikia.com/wiki/Just_Cause_2");
			}
		});
		btnJcWiki.setText("JC2 Wiki");
		btnJcWiki.setBounds(852, 155, 128, 25);
		
		Button btnLoadIrc = new Button(shell, SWT.NONE);
		btnLoadIrc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IRC irc = new IRC();
				irc.open();
			}
		});
		btnLoadIrc.setText("Load IRC");
		btnLoadIrc.setBounds(1089, 31, 128, 25);
		
		Label lblOtherApplets = new Label(shell, SWT.NONE);
		lblOtherApplets.setToolTipText("These will open new windows that have useful tools");
		lblOtherApplets.setBounds(1089, 10, 80, 15);
		lblOtherApplets.setText("Other Applets");
		
		Button btnGoogle = new Button(shell, SWT.NONE);
		btnGoogle.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("http://google.com");
			}
		});
		btnGoogle.setText("Google");
		btnGoogle.setBounds(1089, 73, 128, 25);
		
		Button btnDeveloperInfo = new Button(shell, SWT.NONE);
		btnDeveloperInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DEV devel = new DEV();
				devel.open();
			}
		});
		btnDeveloperInfo.setText("Developer Info");
		btnDeveloperInfo.setBounds(1089, 117, 128, 25);
		
		
		browser.setBounds(0, 0, 838, 611);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(844, 273, 450, 2);
		
		Label lblUpdates = new Label(shell, SWT.NONE);
		lblUpdates.setBounds(854, 288, 55, 15);
		lblUpdates.setText("Updates");
		
		List list = new List(shell, SWT.BORDER);
		list.setItems(new String[] {"You can click either of the buttons below to download any updates ", "that have been released"});
		list.setBounds(844, 309, 429, 68);
		list.setEnabled(false);
		
		Button btnDownloadFromMediafire = new Button(shell, SWT.NONE);
		btnDownloadFromMediafire.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			lblComingSoon.setVisible(true);
			}
		});
		btnDownloadFromMediafire.setBounds(852, 398, 155, 25);
		btnDownloadFromMediafire.setText("Download from Mediafire");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("https://www.dropbox.com/s/idusm6l6i1xo1b2/PDFBrowser.jar?dl=0");
			}
		});
		btnNewButton.setBounds(852, 429, 155, 25);
		btnNewButton.setText("Download from Dropbox");
		
		Button btnDownloadFromMeganz = new Button(shell, SWT.NONE);
		btnDownloadFromMeganz.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String decrypt = "!JZq1nF76cpPUgozSDK0bpUHvCV7IKxKiCkMuUqjttzw";
				browser.setUrl("https://mega.nz/#!5UdTQL4Z");
				MessageDialog.openInformation(shell, "Mega.nz Information", "The page is now loading! The Decrytion Key will be copied to your \r\nclipboard once you close this notification");
				StringSelection stringSel = new StringSelection(decrypt);
				Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
				clip.setContents(stringSel, null);
			}
		});
		btnDownloadFromMeganz.setBounds(852, 463, 155, 25);
		btnDownloadFromMeganz.setText("Download from Mega.nz");
		
		lblComingSoon.setAlignment(SWT.CENTER);
		lblComingSoon.setBounds(1013, 403, 80, 15);
		lblComingSoon.setText("Coming Soon!");
		
		
		label_2.setText("Coming Soon!");
		label_2.setAlignment(SWT.CENTER);
		label_2.setBounds(1013, 468, 80, 15);
		
		Button btnSteam = new Button(shell, SWT.NONE);
		btnSteam.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("steam://run/259080");
			}
		});
		btnSteam.setBounds(959, 203, 113, 25);
		btnSteam.setText("Start JC2");
		
		Button btnOpenSteam = new Button(shell, SWT.NONE);
		btnOpenSteam.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			browser.setUrl("steam://open/main");
			}
		});
		btnOpenSteam.setText("Open Steam");
		btnOpenSteam.setBounds(852, 203, 101, 25);
		
		Button btnOpenPdfGroup = new Button(shell, SWT.NONE);
		btnOpenPdfGroup.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl("steam://url/GroupSteamIDPage/103582791440817797");
			}
		});
		btnOpenPdfGroup.setText("Open PDF Group");
		btnOpenPdfGroup.setBounds(852, 234, 101, 25);
		
		Button btnConnectToJcatc = new Button(shell, SWT.NONE);
		btnConnectToJcatc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			browser.setUrl("steam://connect/108.61.197.240:7777");
			}
		});
		btnConnectToJcatc.setText("Connect to JC2ATC");
		btnConnectToJcatc.setBounds(959, 234, 113, 25);
		
		

	}
}
