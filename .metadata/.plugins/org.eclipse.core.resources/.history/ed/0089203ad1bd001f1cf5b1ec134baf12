package co.kh.dev.home.control;
import co.kh.dev.home.action.Action;
import co.kh.dev.home.action.alert.BoardListAlertAction;
import co.kh.dev.home.action.alert.BoardPageAlertAction;
import co.kh.dev.home.action.alert.MainPageAlertAction;
import co.kh.dev.home.action.alert.MyPageAlertAction;
import co.kh.dev.home.action.alert.PopLoginAlertAction;
import co.kh.dev.home.action.board.BoardCommentInsertAction;
import co.kh.dev.home.action.board.BoardFindSelectAction;
import co.kh.dev.home.action.board.BoardInsertAction;
import co.kh.dev.home.action.board.BoardListDeleteAction;
import co.kh.dev.home.action.board.BoardListSelectAction;
import co.kh.dev.home.action.board.BoardListUpdateAction;
import co.kh.dev.home.action.board.BoardSelectAction;
import co.kh.dev.home.action.customer.CustomerDeleteAction;
import co.kh.dev.home.action.customer.CustomerIdDupCheckAction;
import co.kh.dev.home.action.customer.CustomerInsertAction;
import co.kh.dev.home.action.customer.CustomerInsertCheckAction;
import co.kh.dev.home.action.customer.CustomerLoginCheckAction;
import co.kh.dev.home.action.customer.CustomerLogoutAction;
import co.kh.dev.home.action.customer.CustomerPopLoginCheckAction;
import co.kh.dev.home.action.customer.CustomerUpdateAction;

public class ActionFactory {
	private static ActionFactory af = null;

	public static synchronized ActionFactory getInstance() {
		if (af == null) {
			af = new ActionFactory();
		}
		return af;
	}

	private ActionFactory() {
		super();
	}

	public Action getAction(String cmd) {
		Action action = null;

		switch (cmd) {
		case "boardAlert": 
			action = new BoardPageAlertAction();
			break;
		case "popLoginAlert": 
			action = new PopLoginAlertAction();
			break;
		case "mainPageAlert": 
			action = new MainPageAlertAction();
			break;
		case "myPageAlert": 
			action = new MyPageAlertAction();
			break;
		case "boardListAlert": 
			action = new BoardListAlertAction();
			break;
		case "boardSelect": 
			action = new BoardSelectAction();
			break;
		case "boardInsert": 
			action = new BoardInsertAction();
			break;
		case "boardFindSelect": 
			action = new BoardFindSelectAction();
			break;
		case "boardListSelect": 
			action = new BoardListSelectAction();
			break;
		case "boardListDelete": 
			action = new BoardListDeleteAction();
			break;
		case "boardListUpdate": 
			action = new BoardListUpdateAction();
			break;
		case "boardCommentInsert": 
			action = new BoardCommentInsertAction();
			break;
		case "customerUpdate": 
			action = new CustomerUpdateAction();
			break;
		case "customerLoginCheck": 
			action = new CustomerLoginCheckAction();
			break;
		case "customerPopLoginCheck": 
			action = new CustomerPopLoginCheckAction();
			break;
		case "customerDelete": 
			action = new CustomerDeleteAction();
			break;
		case "customerLogout": 
			action = new CustomerLogoutAction();
			break;
		case "customerIdDupCheck": 
			action = new CustomerIdDupCheckAction();
			break;
		case "customerInsert": 
			action = new CustomerInsertAction();
			break;
		case "customerInsertCheck": 
			action = new CustomerInsertCheckAction();
			break;
		
		default: 
			action = null;
			break;
		}
		return action;
	}

}
