package se.intesvensk;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.browser.Browser;

public class IRC {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IRC window = new IRC();
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
		shell.setSize(900, 500);
		shell.setText("PDF IRC Chat");
		
		Browser browser = new Browser(shell, SWT.NONE);
		browser.setBounds(0, 0, 894, 471);
		browser.setUrl("http://webchat.esper.net/?channels=PDFOfficial");

	}
}
