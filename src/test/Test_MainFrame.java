package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test_MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Test_MainFrame() {
        setTitle("GUI Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 기본 프로그램의 배경색을 보라색으로 설정
        getContentPane().setBackground(new Color(226, 212, 23)); 

        JMenuBar menuBar = new JMenuBar();

        // Main Menus
        JMenu myInfoMenu = new JMenu("내 정보");
        JMenu storeManagementMenu = new JMenu("매장 관리");
        JMenu inventoryManagementMenu = new JMenu("재고 관리");
        JMenu personnelManagementMenu = new JMenu("인사 관리");

        // Submenus for "내 정보"
        JMenuItem infoInquiryItem = new JMenuItem("정보 조회");
        JMenuItem vacationRequestItem = new JMenuItem("휴가 신청");
        JMenuItem scheduleManagementItem = new JMenuItem("스케줄 관리");

        // Submenus for "매장 관리"
        JMenuItem menuManagementItem = new JMenuItem("메뉴 관리");
        JMenuItem eventManagementItem = new JMenuItem("이벤트 관리");

        // Submenus for "재고 관리"
        JMenuItem inventoryInquiryItem = new JMenuItem("재고 조회");
        JMenuItem materialOrderItem = new JMenuItem("재료 주문");

        // Submenus for "인사 관리"
        JMenuItem employeeManagementItem = new JMenuItem("직원 관리");
        JMenuItem payrollManagementItem = new JMenuItem("급여 관리");
        JMenuItem reportItem = new JMenuItem("보고서");

        // Add submenus to main menus
        myInfoMenu.add(infoInquiryItem);
        myInfoMenu.add(vacationRequestItem);
        myInfoMenu.add(scheduleManagementItem);

        storeManagementMenu.add(menuManagementItem);
        storeManagementMenu.add(eventManagementItem);

        inventoryManagementMenu.add(inventoryInquiryItem);
        inventoryManagementMenu.add(materialOrderItem);

        personnelManagementMenu.add(employeeManagementItem);
        personnelManagementMenu.add(payrollManagementItem);
        personnelManagementMenu.add(reportItem);

        // Add main menus to menu bar
        menuBar.add(myInfoMenu);
        menuBar.add(storeManagementMenu);
        menuBar.add(inventoryManagementMenu);
        menuBar.add(personnelManagementMenu);

        // 메뉴 선택의 배경색을 노란색 계통으로 설정
        menuBar.setBackground(new Color(255, 255, 153)); 

        setJMenuBar(menuBar);

        // Main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add empty panels for each submenu
        mainPanel.add(createPanel("정보 조회", Color.WHITE), "정보 조회");
        mainPanel.add(createPanel("휴가 신청", Color.LIGHT_GRAY), "휴가 신청");
        mainPanel.add(createPanel("스케줄 관리", Color.LIGHT_GRAY), "스케줄 관리");
        mainPanel.add(createPanel("메뉴 관리", Color.LIGHT_GRAY), "메뉴 관리");
        mainPanel.add(createPanel("이벤트 관리", Color.LIGHT_GRAY), "이벤트 관리");
        mainPanel.add(createPanel("재고 조회", Color.LIGHT_GRAY), "재고 조회");
        mainPanel.add(createPanel("재료 주문", Color.LIGHT_GRAY), "재료 주문");
        mainPanel.add(createPanel("직원 관리", Color.LIGHT_GRAY), "직원 관리");
        mainPanel.add(createPanel("급여 관리", Color.LIGHT_GRAY), "급여 관리");
        mainPanel.add(createPanel("보고서", Color.LIGHT_GRAY), "보고서");

        add(mainPanel);

        // Action listeners for submenus
        infoInquiryItem.addActionListener(e -> cardLayout.show(mainPanel, "정보 조회"));
        vacationRequestItem.addActionListener(e -> cardLayout.show(mainPanel, "휴가 신청"));
        scheduleManagementItem.addActionListener(e -> cardLayout.show(mainPanel, "스케줄 관리"));
        menuManagementItem.addActionListener(e -> cardLayout.show(mainPanel, "메뉴 관리"));
        eventManagementItem.addActionListener(e -> cardLayout.show(mainPanel, "이벤트 관리"));
        inventoryInquiryItem.addActionListener(e -> cardLayout.show(mainPanel, "재고 조회"));
        materialOrderItem.addActionListener(e -> cardLayout.show(mainPanel, "재료 주문"));
        employeeManagementItem.addActionListener(e -> cardLayout.show(mainPanel, "직원 관리"));
        payrollManagementItem.addActionListener(e -> cardLayout.show(mainPanel, "급여 관리"));
        reportItem.addActionListener(e -> cardLayout.show(mainPanel, "보고서"));
    }

    private JPanel createPanel(String title, Color bgColor) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColor); // 배경색 설정
        panel.add(new JLabel(title));
        // Add additional components here
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Test_MainFrame mainFrame = new Test_MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
