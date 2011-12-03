/*
 * AddictionManagerView.java
 */

package addictionmanager;

import addictionmanager.storage.Task;
import addictionmanager.storage.TaskType;
import addictionmanager.storage.TasksResponse;
import addictionmanager.wizard.WizardView;
import java.awt.Dimension;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.application.Application;

/**
 * The application's main frame.
 */
public class AddictionManagerView extends FrameView {

    public AddictionManagerView(SingleFrameApplication app) {
        super(app);

        initComponents();
        
        currentTaskNavOption.setSelected(true);
        currentTaskNavOption.setFocusable(true);
        changeTaskData(AddictionManagerApp.getStorageUtility().getDocument(TaskType.CURRENT));
        
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = AddictionManagerApp.getApplication().getMainFrame();
            aboutBox = new AddictionManagerAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        AddictionManagerApp.getApplication().show(aboutBox);
    }
    
    private void changeTaskData(TasksResponse tResponse) {
 
        DefaultTableModel dtm = (DefaultTableModel)tasksTable.getModel();
        
        if (dtm.getRowCount() > 1) {
            dtm.setRowCount(0);
        }
        
        if (tResponse != null) {
            for (Task t : tResponse.getTask()) {
               Object o[] = {false, 
                   t.getId(), t.getName(), t.getDescription(), t.getStartDateTime(), t.getEndDateTime(), 
                   t.getAllowedApplications().toString(), t.getRestrictedApplications().toString(), 
                   t.getNotificationType()};

               dtm.addRow(o);
            }
        }
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        mainPanel = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        currentTaskNavOption = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nextTaskNavOption = new javax.swing.JButton();
        todayTaskNavOption = new javax.swing.JButton();
        scheduleTaskNavOption = new javax.swing.JButton();
        someDayTaskNavOption = new javax.swing.JButton();
        logBookNavOption = new javax.swing.JButton();
        trashCanNavOption = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        newTaskBtn = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        editRow = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(addictionmanager.AddictionManagerApp.class).getContext().getResourceMap(AddictionManagerView.class);
        jDesktopPane1.setBackground(resourceMap.getColor("jDesktopPane1.background")); // NOI18N
        jDesktopPane1.setName("jDesktopPane1"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 160, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );

        jPanel1.setBounds(10, 20, 160, 100);
        jDesktopPane1.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jDesktopPane2.setBackground(resourceMap.getColor("siderBarPanel.background")); // NOI18N
        jDesktopPane2.setName("siderBarPanel"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.setBounds(10, 70, 50, 16);
        jDesktopPane2.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        currentTaskNavOption.setIcon(resourceMap.getIcon("currentTaskNavOption.icon")); // NOI18N
        currentTaskNavOption.setText(resourceMap.getString("currentTaskNavOption.text")); // NOI18N
        currentTaskNavOption.setToolTipText(resourceMap.getString("currentTaskNavOption.toolTipText")); // NOI18N
        currentTaskNavOption.setName("currentTaskNavOption"); // NOI18N
        currentTaskNavOption.setSelected(true);
        currentTaskNavOption.setSelectedIcon(resourceMap.getIcon("currentTaskNavOption.selectedIcon")); // NOI18N
        currentTaskNavOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentTaskNavOptionActionPerformed(evt);
            }
        });
        currentTaskNavOption.setBounds(0, 30, 180, 30);
        jDesktopPane2.add(currentTaskNavOption, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setForeground(resourceMap.getColor("jLabel2.foreground")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jLabel2.setBounds(10, 10, 70, 15);
        jDesktopPane2.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        nextTaskNavOption.setIcon(resourceMap.getIcon("nextActivityBtn.icon")); // NOI18N
        nextTaskNavOption.setText(resourceMap.getString("nextActivityBtn.text")); // NOI18N
        nextTaskNavOption.setToolTipText(resourceMap.getString("nextActivityBtn.toolTipText")); // NOI18N
        nextTaskNavOption.setName("nextActivityBtn"); // NOI18N
        nextTaskNavOption.setSelected(true);
        nextTaskNavOption.setSelectedIcon(resourceMap.getIcon("nextActivityBtn.selectedIcon")); // NOI18N
        nextTaskNavOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTaskNavOptionActionPerformed(evt);
            }
        });
        nextTaskNavOption.setBounds(0, 120, 180, 30);
        jDesktopPane2.add(nextTaskNavOption, javax.swing.JLayeredPane.DEFAULT_LAYER);

        todayTaskNavOption.setIcon(resourceMap.getIcon("todayActivityBtn.icon")); // NOI18N
        todayTaskNavOption.setText(resourceMap.getString("todayActivityBtn.text")); // NOI18N
        todayTaskNavOption.setToolTipText(resourceMap.getString("todayActivityBtn.toolTipText")); // NOI18N
        todayTaskNavOption.setName("todayActivityBtn"); // NOI18N
        todayTaskNavOption.setSelected(true);
        todayTaskNavOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todayTaskNavOptionActionPerformed(evt);
            }
        });
        todayTaskNavOption.setBounds(0, 90, 180, 30);
        jDesktopPane2.add(todayTaskNavOption, javax.swing.JLayeredPane.DEFAULT_LAYER);

        scheduleTaskNavOption.setIcon(resourceMap.getIcon("scheduleActivityBtn.icon")); // NOI18N
        scheduleTaskNavOption.setText(resourceMap.getString("scheduleActivityBtn.text")); // NOI18N
        scheduleTaskNavOption.setToolTipText(resourceMap.getString("scheduleActivityBtn.toolTipText")); // NOI18N
        scheduleTaskNavOption.setName("scheduleActivityBtn"); // NOI18N
        scheduleTaskNavOption.setSelected(true);
        scheduleTaskNavOption.setSelectedIcon(resourceMap.getIcon("scheduleActivityBtn.selectedIcon")); // NOI18N
        scheduleTaskNavOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleTaskNavOptionActionPerformed(evt);
            }
        });
        scheduleTaskNavOption.setBounds(0, 150, 180, 30);
        jDesktopPane2.add(scheduleTaskNavOption, javax.swing.JLayeredPane.DEFAULT_LAYER);

        someDayTaskNavOption.setIcon(resourceMap.getIcon("somedayActivityBtn.icon")); // NOI18N
        someDayTaskNavOption.setText(resourceMap.getString("somedayActivityBtn.text")); // NOI18N
        someDayTaskNavOption.setToolTipText(resourceMap.getString("somedayActivityBtn.toolTipText")); // NOI18N
        someDayTaskNavOption.setName("somedayActivityBtn"); // NOI18N
        someDayTaskNavOption.setSelected(true);
        someDayTaskNavOption.setSelectedIcon(resourceMap.getIcon("somedayActivityBtn.selectedIcon")); // NOI18N
        someDayTaskNavOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                someDayTaskNavOptionActionPerformed(evt);
            }
        });
        someDayTaskNavOption.setBounds(0, 180, 180, 30);
        jDesktopPane2.add(someDayTaskNavOption, javax.swing.JLayeredPane.DEFAULT_LAYER);

        logBookNavOption.setIcon(resourceMap.getIcon("logbookBtn.icon")); // NOI18N
        logBookNavOption.setText(resourceMap.getString("logbookBtn.text")); // NOI18N
        logBookNavOption.setToolTipText(resourceMap.getString("logbookBtn.toolTipText")); // NOI18N
        logBookNavOption.setName("logbookBtn"); // NOI18N
        logBookNavOption.setSelected(true);
        logBookNavOption.setSelectedIcon(resourceMap.getIcon("logbookBtn.selectedIcon")); // NOI18N
        logBookNavOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logBookNavOptionActionPerformed(evt);
            }
        });
        logBookNavOption.setBounds(0, 560, 180, 30);
        jDesktopPane2.add(logBookNavOption, javax.swing.JLayeredPane.DEFAULT_LAYER);

        trashCanNavOption.setIcon(resourceMap.getIcon("trashBtn.icon")); // NOI18N
        trashCanNavOption.setText(resourceMap.getString("trashBtn.text")); // NOI18N
        trashCanNavOption.setToolTipText(resourceMap.getString("trashBtn.toolTipText")); // NOI18N
        trashCanNavOption.setName("trashBtn"); // NOI18N
        trashCanNavOption.setSelected(true);
        trashCanNavOption.setSelectedIcon(resourceMap.getIcon("trashBtn.selectedIcon")); // NOI18N
        trashCanNavOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trashCanNavOptionActionPerformed(evt);
            }
        });
        trashCanNavOption.setBounds(0, 590, 180, 30);
        jDesktopPane2.add(trashCanNavOption, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel2.setBackground(resourceMap.getColor("centerPanel.background")); // NOI18N
        jPanel2.setForeground(resourceMap.getColor("centerPanel.foreground")); // NOI18N
        jPanel2.setName("centerPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tasksTable.setBackground(resourceMap.getColor("tasksTable.background")); // NOI18N
        tasksTable.setFont(resourceMap.getFont("tasksTable.font")); // NOI18N
        tasksTable.setForeground(resourceMap.getColor("tasksTable.foreground")); // NOI18N
        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Task no.", "Task Name", "Task Description", "Allowed Applications", "Restricted Applications", "Start Date & Time", "End Date & Time", "Notification Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tasksTable.setColumnSelectionAllowed(true);
        tasksTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tasksTable.setGridColor(resourceMap.getColor("tasksTable.gridColor")); // NOI18N
        tasksTable.setName("tasksTable"); // NOI18N
        tasksTable.setRowHeight(30);
        tasksTable.setRowMargin(3);
        tasksTable.setSelectionBackground(resourceMap.getColor("tasksTable.selectionBackground")); // NOI18N
        tasksTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(tasksTable);
        tasksTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tasksTable.getColumnModel().getColumn(0).setMinWidth(15);
        tasksTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        tasksTable.getColumnModel().getColumn(0).setMaxWidth(20);
        tasksTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tasksTable.columnModel.title6")); // NOI18N
        tasksTable.getColumnModel().getColumn(1).setMinWidth(40);
        tasksTable.getColumnModel().getColumn(1).setPreferredWidth(55);
        tasksTable.getColumnModel().getColumn(1).setMaxWidth(55);
        tasksTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tasksTable.columnModel.title0")); // NOI18N
        tasksTable.getColumnModel().getColumn(2).setMinWidth(80);
        tasksTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        tasksTable.getColumnModel().getColumn(2).setMaxWidth(220);
        tasksTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tasksTable.columnModel.title1")); // NOI18N
        tasksTable.getColumnModel().getColumn(3).setMinWidth(150);
        tasksTable.getColumnModel().getColumn(3).setPreferredWidth(220);
        tasksTable.getColumnModel().getColumn(3).setMaxWidth(320);
        tasksTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tasksTable.columnModel.title9")); // NOI18N
        tasksTable.getColumnModel().getColumn(4).setMinWidth(80);
        tasksTable.getColumnModel().getColumn(4).setPreferredWidth(140);
        tasksTable.getColumnModel().getColumn(4).setMaxWidth(240);
        tasksTable.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("tasksTable.columnModel.title2")); // NOI18N
        tasksTable.getColumnModel().getColumn(5).setMinWidth(120);
        tasksTable.getColumnModel().getColumn(5).setPreferredWidth(160);
        tasksTable.getColumnModel().getColumn(5).setMaxWidth(260);
        tasksTable.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("tasksTable.columnModel.title3")); // NOI18N
        tasksTable.getColumnModel().getColumn(6).setMinWidth(80);
        tasksTable.getColumnModel().getColumn(6).setPreferredWidth(120);
        tasksTable.getColumnModel().getColumn(6).setMaxWidth(220);
        tasksTable.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("tasksTable.columnModel.title4")); // NOI18N
        tasksTable.getColumnModel().getColumn(7).setMinWidth(80);
        tasksTable.getColumnModel().getColumn(7).setPreferredWidth(120);
        tasksTable.getColumnModel().getColumn(7).setMaxWidth(220);
        tasksTable.getColumnModel().getColumn(7).setHeaderValue(resourceMap.getString("tasksTable.columnModel.title7")); // NOI18N
        tasksTable.getColumnModel().getColumn(8).setMinWidth(80);
        tasksTable.getColumnModel().getColumn(8).setPreferredWidth(100);
        tasksTable.getColumnModel().getColumn(8).setMaxWidth(200);
        tasksTable.getColumnModel().getColumn(8).setHeaderValue(resourceMap.getString("tasksTable.columnModel.title8")); // NOI18N

        jDesktopPane3.setBackground(resourceMap.getColor("jDesktopPane3.background")); // NOI18N
        jDesktopPane3.setName("jDesktopPane3"); // NOI18N

        newTaskBtn.setText(resourceMap.getString("newTaskBtn.text")); // NOI18N
        newTaskBtn.setName("newTaskBtn"); // NOI18N
        newTaskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTaskBtnActionPerformed(evt);
            }
        });
        newTaskBtn.setBounds(20, 10, 97, 29);
        jDesktopPane3.add(newTaskBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton9.setText(resourceMap.getString("jButton9.text")); // NOI18N
        jButton9.setEnabled(false);
        jButton9.setName("jButton9"); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jButton9.setBounds(920, 10, 110, 29);
        jDesktopPane3.add(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        editRow.setText(resourceMap.getString("editRow.text")); // NOI18N
        editRow.setEnabled(false);
        editRow.setName("editRow"); // NOI18N
        editRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRowActionPerformed(evt);
            }
        });
        editRow.setBounds(810, 10, 110, 29);
        jDesktopPane3.add(editRow, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane3)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jDesktopPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        org.jdesktop.layout.GroupLayout mainPanelLayout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup()
                .add(jDesktopPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jDesktopPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jDesktopPane2)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuBar.setName("menuBar"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, menuBar, org.jdesktop.beansbinding.ELProperty.create("${background}"), menuBar, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        fileMenu.setBackground(resourceMap.getColor("fileMenu.background")); // NOI18N
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jSeparator1.setName("jSeparator1"); // NOI18N
        fileMenu.add(jSeparator1);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(addictionmanager.AddictionManagerApp.class).getContext().getActionMap(AddictionManagerView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setBackground(resourceMap.getColor("helpMenu.background")); // NOI18N
        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setIcon(resourceMap.getIcon("aboutMenuItem.icon")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AddictionManagerApp app = (AddictionManagerApp)getApplication();
        
        if (app!= null) {
            WizardView wv = WizardView.loadWizardView();
            app.setWizardViewManager(wv);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void currentTaskNavOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentTaskNavOptionActionPerformed
        // TODO add your handling code here:
        changeTaskData(AddictionManagerApp.getStorageUtility().getDocument(TaskType.CURRENT));
        
    }//GEN-LAST:event_currentTaskNavOptionActionPerformed

    private void todayTaskNavOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayTaskNavOptionActionPerformed
        // TODO add your handling code here:
        changeTaskData(AddictionManagerApp.getStorageUtility().getDocument(TaskType.TODAY));
    }//GEN-LAST:event_todayTaskNavOptionActionPerformed

    private void nextTaskNavOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTaskNavOptionActionPerformed
        // TODO add your handling code here:
        changeTaskData(AddictionManagerApp.getStorageUtility().getDocument(TaskType.TOMORROW));
    }//GEN-LAST:event_nextTaskNavOptionActionPerformed

    private void scheduleTaskNavOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleTaskNavOptionActionPerformed
        // TODO add your handling code here:
        changeTaskData(AddictionManagerApp.getStorageUtility().getDocument(TaskType.SCHEDULED));
    }//GEN-LAST:event_scheduleTaskNavOptionActionPerformed

    private void someDayTaskNavOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_someDayTaskNavOptionActionPerformed
        // TODO add your handling code here:
        changeTaskData(AddictionManagerApp.getStorageUtility().getDocument(TaskType.SOMEDAY));
    }//GEN-LAST:event_someDayTaskNavOptionActionPerformed

    private void logBookNavOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logBookNavOptionActionPerformed
        // TODO add your handling code here:
        changeTaskData(AddictionManagerApp.getStorageUtility().getDocument(TaskType.LOGGED));
    }//GEN-LAST:event_logBookNavOptionActionPerformed

    private void trashCanNavOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trashCanNavOptionActionPerformed
        // TODO add your handling code here:
        changeTaskData(AddictionManagerApp.getStorageUtility().getDocument(TaskType.TRASHED));
    }//GEN-LAST:event_trashCanNavOptionActionPerformed

    private void newTaskBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTaskBtnActionPerformed
        // TODO add your handling code here:
        AddictionManagerApp app = (AddictionManagerApp)getApplication();
        
        if (app!= null) {
            WizardView wv = WizardView.loadWizardView();
            app.setWizardViewManager(wv);
        }
    }//GEN-LAST:event_newTaskBtnActionPerformed

    private void editRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editRowActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton currentTaskNavOption;
    private javax.swing.JButton editRow;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public javax.swing.JButton logBookNavOption;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    public javax.swing.JButton newTaskBtn;
    public javax.swing.JButton nextTaskNavOption;
    public javax.swing.JButton scheduleTaskNavOption;
    public javax.swing.JButton someDayTaskNavOption;
    public javax.swing.JTable tasksTable;
    public javax.swing.JButton todayTaskNavOption;
    public javax.swing.JButton trashCanNavOption;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables


    private JDialog aboutBox;
}
