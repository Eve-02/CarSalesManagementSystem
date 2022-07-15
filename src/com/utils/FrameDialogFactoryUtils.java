package com.utils;

import com.controller.*;
import com.view.Dialog.*;
import com.view.Frame.*;

import javax.swing.*;

public class FrameDialogFactoryUtils {

    // JFrame
    private static CarFrame carFrame = new CarFrame();
    private static CustomerFrame customerFrame = new CustomerFrame();
    private static EmployeeFrame employeeFrame = new EmployeeFrame();
    private static ProcurementFrame procurementFrame = new ProcurementFrame();
    private static SaleFrame saleFrame = new SaleFrame();
    private static IndexFrame indexFrame = new IndexFrame();
    private static LoginFrame loginFrame = new LoginFrame();
    private static ChangePasswordDialog changePasswordDialog;

    // get_Frame
    public static OperateDateFrame getFrame(JFrame jFrame){
        if(jFrame instanceof CarFrame){
            return carFrame;
        }else if(jFrame instanceof  CustomerFrame){
            return customerFrame;
        }else if(jFrame instanceof EmployeeFrame){
            return employeeFrame;
        }else if(jFrame instanceof ProcurementFrame){
            return procurementFrame;
        }else if(jFrame instanceof SaleFrame){
            return saleFrame;
        }
        return null;
    }

    // get_AddDialog
    public static BasicAddDialog getAddDialog(JFrame jFrame){
        if(jFrame instanceof CarFrame){
            return new CarAddDialog();
        }else if(jFrame instanceof  CustomerFrame){
            return new CustomerAddDialog();
        }else if(jFrame instanceof EmployeeFrame){
            return new EmployeeAddDialog();
        }else if(jFrame instanceof ProcurementFrame){
            return new ProcurementAddDialog();
        }else if(jFrame instanceof SaleFrame){
            return new SaleAddDialog();
        }
        return null;
    }

    // get_changeDialog
    public static BasicChangeDialog getChangeDialog(JFrame jFrame){
        if(jFrame instanceof CarFrame){
            return new CarChangeDialog();
        }else if(jFrame instanceof  CustomerFrame){
            return new CustomerChangeDialog();
        }else if(jFrame instanceof EmployeeFrame){
            return new EmployeeChangeDialog();
        }else if(jFrame instanceof ProcurementFrame){
            return new ProcurementChangeDialog();
        }else if(jFrame instanceof SaleFrame){
            return new SaleChangeDialog();
        }
        return null;
    }

    // get_selectDialog
    public static BasicSelectDialog getSelectDialog(JFrame jFrame){
        if(jFrame instanceof CarFrame){
            return new CarSelectDialog();
        }else if(jFrame instanceof  CustomerFrame){
            return new CustomerSelectDialog();
        }else if(jFrame instanceof EmployeeFrame){
            return new EmployeeSelectDialog();
        }else if(jFrame instanceof ProcurementFrame){
            return new ProcurementSelectDialog();
        }else if(jFrame instanceof SaleFrame){
            return new SaleSelectDialog();
        }
        return null;
    }

    // get_Action
    public static Curd getAction(JFrame jFrame){
        if(jFrame instanceof CarFrame){
            return new carAction();
        }else if(jFrame instanceof  CustomerFrame){
            return new customerAction();
        }else if(jFrame instanceof EmployeeFrame){
            return new employeeAction();
        }else if(jFrame instanceof ProcurementFrame){
            return new procurementAction();
        }else if(jFrame instanceof SaleFrame){
            return new saleAction();
        }
        return null;
    }

    public static void setChangePasswordDialog(int id,String password){
        changePasswordDialog = new ChangePasswordDialog(id,password);
    }

    public static CarFrame getCarFrame(){
        return carFrame;
    }

    public static CustomerFrame getCustomerFrame(){
        return customerFrame;
    }

    public static EmployeeFrame getEmployeeFrame(){
        return employeeFrame;
    }
    public static ProcurementFrame getProcurementFrame(){
        return procurementFrame;
    }
    public static SaleFrame getSaleFrame(){
        return saleFrame;
    }
    public static IndexFrame getIndexFrame(){
        return indexFrame;
    }

    public static LoginFrame getLoginFrame(){
        return loginFrame;
    }

    public static ChangePasswordDialog getChangePasswordDialog(){
        return changePasswordDialog;
    }
}
