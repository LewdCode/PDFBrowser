package se.intesvensk;

import java.awt.Toolkit;
import java.awt.datatransfer.*;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DEV {
	private static String payPal = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=49CYBSJ7EXCQJ";
	private static String twitter = "http://twitter.com/inte_svensk";
	private static String steam = "http://steamcommunity.com/id/intesvensk";
	private static String bitcoin = "1kYHbdtyXPt9YR3Hn4hBjrqsyBGFdPuee";
	protected Shell shlDeveloperInformation;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DEV window = new DEV();
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
		shlDeveloperInformation.open();
		shlDeveloperInformation.layout();
		while (!shlDeveloperInformation.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDeveloperInformation = new Shell(SWT.CLOSE | SWT.TITLE | SWT.BORDER |
				SWT.APPLICATION_MODAL | SWT.MIN );
		shlDeveloperInformation.setSize(900, 500);
		shlDeveloperInformation.setText("Developer Information");
		
		Browser browser = new Browser(shlDeveloperInformation, SWT.NONE);
		browser.setBounds(10, 10, 705, 451);
		
		Button btnPaypal = new Button(shlDeveloperInformation, SWT.NONE);
		btnPaypal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl(payPal);
			}
		});
		btnPaypal.setBounds(727, 33, 75, 25);
		btnPaypal.setText("PayPal");
		
		Button btnBitcoin = new Button(shlDeveloperInformation, SWT.NONE);
		btnBitcoin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(shlDeveloperInformation, "Bitcoin Donation", "My bitcoin address is: \r\n\r\n" + bitcoin + ". \r\n\r\nThis has been copied to your clipboard.");
				StringSelection stringSel = new StringSelection(bitcoin);
				Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
				clip.setContents(stringSel, null);
			}
		});
		btnBitcoin.setBounds(809, 33, 75, 25);
		btnBitcoin.setText("Bitcoin");
		
		Label lblDonateOptions = new Label(shlDeveloperInformation, SWT.NONE);
		lblDonateOptions.setBounds(767, 10, 102, 15);
		lblDonateOptions.setText("Donate Options");
		
		List list = new List(shlDeveloperInformation, SWT.BORDER);
		list.setItems(new String[] {"Why donate?", "", "Donating keeps me fed, ", "and hydrated, and ", "motivates me to make ", "more things and ", "implement features."});
		list.setToolTipText("");
		list.setBounds(731, 64, 153, 109);
		list.setEnabled(false);
		
		Button btnTwitter = new Button(shlDeveloperInformation, SWT.NONE);
		btnTwitter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl(twitter);
			}
		});
		btnTwitter.setBounds(727, 185, 75, 25);
		btnTwitter.setText("Twitter");
		
		Button btnSteam = new Button(shlDeveloperInformation, SWT.NONE);
		btnSteam.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl(steam);
			}
		});
		btnSteam.setBounds(809, 185, 75, 25);
		btnSteam.setText("Steam");

	}
}
