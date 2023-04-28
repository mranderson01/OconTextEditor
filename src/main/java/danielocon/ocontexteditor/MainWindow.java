package danielocon.ocontexteditor;

import com.formdev.flatlaf.FlatLaf;
import help.Help;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
import themes.MiTema;

/**
 *
 * @author Daniel Ocon The MainWindow class represents the main window of a text
 * editor.
 */
public final class MainWindow extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(MainWindow.class.getName());

    /**
     *
     * The file that is currently open.
     */
    private File openedFile;

    /**
     *
     * A boolean flag indicating whether the text in the editor has been changed
     * or not.
     */
    private boolean textChanged;

    /**
     *
     * An UndoManager instance to keep track of the undo and redo operations.
     */
    private final UndoManager undoManager;

    // icon names
    /**
     *
     * An array of icon names for the "New" button.
     */
    private final String[] newIcon = {"new.PNG", "new_white.PNG"};
    /**
     *
     * An array of icon names for the "Open" button.
     */
    private final String[] openIcon = {"open.PNG", "open_white.PNG"};
    /**
     *
     * An array of icon names for the "Save" button.
     */
    private final String[] saveIcon = {"save.PNG", "save_white.PNG"};
    /**
     *
     * An array of icon names for the "Save As" button.
     */
    private final String[] saveAsIcon = {"save_as.PNG", "save_as_white.PNG"};
    /**
     *
     * An array of icon names for the "Help" button.
     */
    private final String[] helpIcon = {"help.PNG", "help_white.PNG"};
    /**
     *
     * An array of icon names for the "Undo" button.
     */
    private final String[] undoIcon = {"undo.PNG", "undo_white.PNG"};
    /**
     *
     * An array of icon names for the "Redo" button.
     */
    private final String[] redoIcon = {"redo.PNG", "redo_white.PNG"};
    /**
     *
     * An array of icon names for the "Cut" button.
     */
    private final String[] cutIcon = {"cut.PNG", "cut_white.PNG"};
    /**
     *
     * An array of icon names for the "Copy" button.
     */
    private final String[] copyIcon = {"copy.PNG", "copy_white.PNG"};
    /**
     *
     * An array of icon names for the "Paste" button.
     */
    private final String[] pasteIcon = {"paste.PNG", "paste_white.PNG"};

    // Hardcoded avaible fonts
    /**
     *
     * An array of available font names on the system.
     */
    private final String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

    /**

The system clipboard instance.
*/
    private final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     *
     * Returns the ImageIcon instance corresponding to the provided icon path.
     *
     * @param path A string representing the path of the icon image file.
     * @return An ImageIcon instance representing the icon image.
     */
    private ImageIcon icon(String path) {
        try {
            BufferedImage img = ImageIO.read(new File("src/main/resources/icons/" + path));
            Image scaled = img.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        } catch (IOException e) {
            LOGGER.severe(e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        otherInits();
        newFile();

        // Set the window to cover the screen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.undoManager = new UndoManager();
        this.textArea.getDocument().addUndoableEditListener(undoManager);

        keyEvents();
        undoRedo();
        elementCounter();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new JFileChooser();
        jPopupMenu = new javax.swing.JPopupMenu();
        javax.swing.JMenuItem jMenuItem_clickUndo = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem_rightClickRedo = new javax.swing.JMenuItem();
        javax.swing.JPopupMenu.Separator jSeparator4 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem jMenuItem_rightClickCut = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem_rightClickCopy = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem_rightClickPaste = new javax.swing.JMenuItem();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel_topPanel = new javax.swing.JPanel();
        javax.swing.JToolBar jToolBar = new javax.swing.JToolBar();
        javax.swing.Box.Filler filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jButton_NewFile = new javax.swing.JButton();
        jButton_OpenFile = new javax.swing.JButton();
        jButton_SaveFile = new javax.swing.JButton();
        javax.swing.JToolBar.Separator jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton_cut = new javax.swing.JButton();
        jButton_copy = new javax.swing.JButton();
        jButton_paste = new javax.swing.JButton();
        jButton_undo = new javax.swing.JButton();
        jButton_Redo = new javax.swing.JButton();
        javax.swing.JToolBar.Separator jSeparator6 = new javax.swing.JToolBar.Separator();
        jButton_ColorChanger = new javax.swing.JButton();
        javax.swing.Box.Filler filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        javax.swing.JLabel jLabel_textSize = new javax.swing.JLabel();
        jSpinner_fontSize = new javax.swing.JSpinner();
        javax.swing.Box.Filler filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        javax.swing.JLabel jLabel_font = new javax.swing.JLabel();
        jComboBox_fonts = new javax.swing.JComboBox<>();
        javax.swing.JToolBar.Separator jSeparator7 = new javax.swing.JToolBar.Separator();
        jButton_Help = new javax.swing.JButton();
        javax.swing.JPanel jPanel_bottomPanel = new javax.swing.JPanel();
        jLabel_lines = new javax.swing.JLabel();
        jLabel_words = new javax.swing.JLabel();
        jLabel_characters = new javax.swing.JLabel();
        javax.swing.JPanel jPanel_leftSpace = new javax.swing.JPanel();
        javax.swing.JPanel jPanel_rightSpace = new javax.swing.JPanel();
        javax.swing.JPanel jPanel_textPanel = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu_File = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItem_NewFile = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem_OpenFile = new javax.swing.JMenuItem();
        javax.swing.JPopupMenu.Separator jSeparator1 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem jMenuItem_Save = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem_SaveAs = new javax.swing.JMenuItem();
        javax.swing.JPopupMenu.Separator jSeparator2 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem jMenuItem_Exit = new javax.swing.JMenuItem();
        javax.swing.JMenu jMenu_Edit = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItem_Undo = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem_Redo = new javax.swing.JMenuItem();
        javax.swing.JPopupMenu.Separator jSeparator3 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem jMenuItem_Cut = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem_Copy = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem_Paste = new javax.swing.JMenuItem();
        javax.swing.JMenu jMenu_Help = new javax.swing.JMenu();

        jMenuItem_clickUndo.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        /*

          An integer representing the current theme of the editor.
         */
        int theme = 1;
        jMenuItem_clickUndo.setIcon(icon(undoIcon[theme]));
        jMenuItem_clickUndo.setText("undo");
        jMenuItem_clickUndo.addActionListener(this::jMenuItem_clickUndoActionPerformed);
        jPopupMenu.add(jMenuItem_clickUndo);

        jMenuItem_rightClickRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_rightClickRedo.setIcon(icon(redoIcon[theme]));
        jMenuItem_rightClickRedo.setText("redo");
        jMenuItem_rightClickRedo.addActionListener(this::jMenuItem_rightClickRedoActionPerformed);
        jPopupMenu.add(jMenuItem_rightClickRedo);
        jPopupMenu.add(jSeparator4);

        jMenuItem_rightClickCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_rightClickCut.setIcon(icon(cutIcon[theme]));
        jMenuItem_rightClickCut.setText("Cut");
        jMenuItem_rightClickCut.addActionListener(this::jMenuItem_rightClickCutActionPerformed);
        jPopupMenu.add(jMenuItem_rightClickCut);


        jMenuItem_rightClickCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_rightClickCopy.setIcon(icon(copyIcon[theme]));
        jMenuItem_rightClickCopy.setText("Copy");
        jMenuItem_rightClickCopy.addActionListener(this::jMenuItem_rightClickCopyActionPerformed);
        jPopupMenu.add(jMenuItem_rightClickCopy);

        jMenuItem_rightClickPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_rightClickPaste.setIcon(icon(pasteIcon[theme]));
        jMenuItem_rightClickPaste.setText("Paste");
        jMenuItem_rightClickPaste.addActionListener(this::jMenuItem_rightClickPasteActionPerformed);
        jPopupMenu.add(jMenuItem_rightClickPaste);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing();
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel_topPanel.setPreferredSize(new java.awt.Dimension(400, 30));
        jPanel_topPanel.setLayout(new java.awt.CardLayout());

        jToolBar.setRollover(true);
        jToolBar.add(filler1);

        jButton_NewFile.setIcon(icon(newIcon[theme]));
        jButton_NewFile.setToolTipText("New file");
        jButton_NewFile.setFocusable(false);
        jButton_NewFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_NewFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_NewFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_NewFileMouseClicked();
            }
        });
        jToolBar.add(jButton_NewFile);

        jButton_OpenFile.setIcon(icon(openIcon[theme]));
        jButton_OpenFile.setToolTipText("Open file");
        jButton_OpenFile.setFocusable(false);
        jButton_OpenFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_OpenFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_OpenFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_OpenFileMouseClicked();
            }
        });
        jToolBar.add(jButton_OpenFile);

        jButton_SaveFile.setIcon(icon(saveIcon[theme]));
        jButton_SaveFile.setToolTipText("Save File");
        jButton_SaveFile.setFocusable(false);
        jButton_SaveFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_SaveFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_SaveFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_SaveFileMouseClicked();
            }
        });
        jToolBar.add(jButton_SaveFile);
        jToolBar.add(jSeparator5);

        jButton_cut.setIcon(icon(cutIcon[theme]));
        jButton_cut.setToolTipText("Cut");
        jButton_cut.setFocusable(false);
        jButton_cut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_cut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_cut.addActionListener(this::jButton_cutActionPerformed);
        jToolBar.add(jButton_cut);

        jButton_copy.setIcon(icon(copyIcon[theme]));
        jButton_copy.setToolTipText("Copy");
        jButton_copy.setFocusable(false);
        jButton_copy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_copy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_copy.addActionListener(this::jButton_copyActionPerformed);
        jToolBar.add(jButton_copy);

        jButton_paste.setIcon(icon(pasteIcon[theme]));
        jButton_paste.setToolTipText("Paste");
        jButton_paste.setFocusable(false);
        jButton_paste.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_paste.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_paste.addActionListener(this::jButton_pasteActionPerformed);
        jToolBar.add(jButton_paste);

        jButton_undo.setIcon(icon(undoIcon[theme]));
        jButton_undo.setToolTipText("Undo");
        jButton_undo.setFocusable(false);
        jButton_undo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_undo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_undo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_undoMouseClicked();
            }
        });
        jToolBar.add(jButton_undo);

        jButton_Redo.setIcon(icon(redoIcon[theme]));
        jButton_Redo.setToolTipText("Redo");
        jButton_Redo.setFocusable(false);
        jButton_Redo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Redo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Redo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_RedoMouseClicked();
            }
        });
        jToolBar.add(jButton_Redo);
        jToolBar.add(jSeparator6);

        jButton_ColorChanger.setText("Text color");
        jButton_ColorChanger.setFocusable(false);
        jButton_ColorChanger.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_ColorChanger.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_ColorChanger.addActionListener(this::jButton_ColorChangerActionPerformed);
        jToolBar.add(jButton_ColorChanger);
        jToolBar.add(filler2);

        jLabel_textSize.setText("Text size:");
        jToolBar.add(jLabel_textSize);

        jSpinner_fontSize.setModel(new javax.swing.SpinnerNumberModel(18, 0, 500, 1));
        jSpinner_fontSize.setMaximumSize(new java.awt.Dimension(65, 32767));
        jSpinner_fontSize.setMinimumSize(new java.awt.Dimension(65, 22));
        jSpinner_fontSize.setPreferredSize(new java.awt.Dimension(65, 22));
        jSpinner_fontSize.addChangeListener(this::jSpinner_fontSizeStateChanged);
        jToolBar.add(jSpinner_fontSize);
        jToolBar.add(filler3);

        jLabel_font.setText("Font:");
        jToolBar.add(jLabel_font);

        jComboBox_fonts.setMaximumSize(new java.awt.Dimension(120, 32767));
        jComboBox_fonts.setMinimumSize(new java.awt.Dimension(120, 22));
        jComboBox_fonts.setPreferredSize(new java.awt.Dimension(120, 22));
        jComboBox_fonts.addItemListener(this::jComboBox_fontsItemStateChanged);
        jToolBar.add(jComboBox_fonts);
        jToolBar.add(jSeparator7);

        jButton_Help.setIcon(icon(helpIcon[theme]));
        jButton_Help.setToolTipText("Help");
        jButton_Help.setFocusable(false);
        jButton_Help.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Help.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(jButton_Help);

        jPanel_topPanel.add(jToolBar, "card2");

        jPanel1.add(jPanel_topPanel, java.awt.BorderLayout.PAGE_START);

        jPanel_bottomPanel.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanel_bottomPanel.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel_bottomPanel.setPreferredSize(new java.awt.Dimension(400, 20));
        jPanel_bottomPanel.setLayout(new java.awt.GridLayout(1, 0));

        jLabel_lines.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_lines.setText("Lines: 0");
        jPanel_bottomPanel.add(jLabel_lines);

        jLabel_words.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_words.setText("Words: 0");
        jPanel_bottomPanel.add(jLabel_words);

        jLabel_characters.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_characters.setText("Characters: 0");
        jPanel_bottomPanel.add(jLabel_characters);

        jPanel1.add(jPanel_bottomPanel, java.awt.BorderLayout.PAGE_END);

        jPanel_leftSpace.setMaximumSize(new java.awt.Dimension(10, 32767));
        jPanel_leftSpace.setMinimumSize(new java.awt.Dimension(10, 0));
        jPanel_leftSpace.setPreferredSize(new java.awt.Dimension(10, 237));

        javax.swing.GroupLayout jPanel_leftSpaceLayout = new javax.swing.GroupLayout(jPanel_leftSpace);
        jPanel_leftSpace.setLayout(jPanel_leftSpaceLayout);
        jPanel_leftSpaceLayout.setHorizontalGroup(
            jPanel_leftSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel_leftSpaceLayout.setVerticalGroup(
            jPanel_leftSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel_leftSpace, java.awt.BorderLayout.LINE_START);

        jPanel_rightSpace.setMaximumSize(new java.awt.Dimension(10, 32767));
        jPanel_rightSpace.setMinimumSize(new java.awt.Dimension(10, 0));
        jPanel_rightSpace.setPreferredSize(new java.awt.Dimension(10, 237));

        javax.swing.GroupLayout jPanel_rightSpaceLayout = new javax.swing.GroupLayout(jPanel_rightSpace);
        jPanel_rightSpace.setLayout(jPanel_rightSpaceLayout);
        jPanel_rightSpaceLayout.setHorizontalGroup(
            jPanel_rightSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel_rightSpaceLayout.setVerticalGroup(
            jPanel_rightSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel_rightSpace, java.awt.BorderLayout.LINE_END);

        jPanel_textPanel.setLayout(new java.awt.CardLayout());

        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textAreaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(textArea);

        jPanel_textPanel.add(jScrollPane1, "card2");

        jPanel1.add(jPanel_textPanel, java.awt.BorderLayout.CENTER);

        jMenu_File.setText("File");

        jMenuItem_NewFile.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_NewFile.setIcon(icon(newIcon[theme]));
        jMenuItem_NewFile.setText("New File");
        jMenuItem_NewFile.addActionListener(this::jMenuItem_NewFileActionPerformed);
        jMenu_File.add(jMenuItem_NewFile);

        jMenuItem_OpenFile.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_OpenFile.setIcon(icon(openIcon[theme]));
        jMenuItem_OpenFile.setText("Open File");
        jMenuItem_OpenFile.addActionListener(this::jMenuItem_OpenFileActionPerformed);
        jMenu_File.add(jMenuItem_OpenFile);
        jMenu_File.add(jSeparator1);

        jMenuItem_Save.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_Save.setIcon(icon(saveIcon[theme]));
        jMenuItem_Save.setText("Save");
        jMenuItem_Save.addActionListener(this::jMenuItem_SaveActionPerformed);
        jMenu_File.add(jMenuItem_Save);

        jMenuItem_SaveAs.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_SaveAs.setIcon(icon(saveAsIcon[theme]));
        jMenuItem_SaveAs.setText("Save as");
        jMenuItem_SaveAs.addActionListener(this::jMenuItem_SaveAsActionPerformed);
        jMenu_File.add(jMenuItem_SaveAs);
        jMenu_File.add(jSeparator2);

        jMenuItem_Exit.setText("Exit");
        jMenuItem_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem_ExitMouseClicked();
            }
        });
        jMenuItem_Exit.addActionListener(this::jMenuItem_ExitActionPerformed);
        jMenu_File.add(jMenuItem_Exit);

        jMenuBar.add(jMenu_File);

        jMenu_Edit.setText("Edit");

        jMenuItem_Undo.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_Undo.setIcon(icon(undoIcon[theme]));
        jMenuItem_Undo.setText("undo");
        jMenuItem_Undo.addActionListener(this::jMenuItem_UndoActionPerformed);
        jMenu_Edit.add(jMenuItem_Undo);

        jMenuItem_Redo.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_Redo.setIcon(icon(redoIcon[theme]));
        jMenuItem_Redo.setText("redo");
        jMenuItem_Redo.addActionListener(this::jMenuItem_RedoActionPerformed);
        jMenu_Edit.add(jMenuItem_Redo);
        jMenu_Edit.add(jSeparator3);

        jMenuItem_Cut.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_Cut.setIcon(icon(cutIcon[theme]));
        jMenuItem_Cut.setText("Cut");
        jMenuItem_Cut.addActionListener(this::jMenuItem_CutActionPerformed);
        jMenu_Edit.add(jMenuItem_Cut);

        jMenuItem_Copy.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_Copy.setIcon(icon(copyIcon[theme]));
        jMenuItem_Copy.setText("Copy");
        jMenuItem_Copy.addActionListener(this::jMenuItem_CopyActionPerformed);
        jMenu_Edit.add(jMenuItem_Copy);

        jMenuItem_Paste.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_Paste.setIcon(icon(pasteIcon[theme]));
        jMenuItem_Paste.setText("Paste");
        jMenuItem_Paste.addActionListener(this::jMenuItem_PasteActionPerformed);
        jMenu_Edit.add(jMenuItem_Paste);

        jMenuBar.add(jMenu_Edit);

        jMenu_Help.setText("Help");
        jMenu_Help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_HelpMouseClicked();
            }
        });
        jMenuBar.add(jMenu_Help);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_NewFileMouseClicked() {//GEN-FIRST:event_jButton_NewFileMouseClicked
        // Generates a new file
        newFile();
    }//GEN-LAST:event_jButton_NewFileMouseClicked

    private void jButton_OpenFileMouseClicked() {//GEN-FIRST:event_jButton_OpenFileMouseClicked
        // Opens a file
        openFile();
    }//GEN-LAST:event_jButton_OpenFileMouseClicked

    private void jButton_SaveFileMouseClicked() {//GEN-FIRST:event_jButton_SaveFileMouseClicked
        // Saves a file
        saveFile();
    }//GEN-LAST:event_jButton_SaveFileMouseClicked

    private void jButton_undoMouseClicked() {//GEN-FIRST:event_jButton_undoMouseClicked
        // Goes one action back
        undo();
    }//GEN-LAST:event_jButton_undoMouseClicked

    private void jButton_RedoMouseClicked() {//GEN-FIRST:event_jButton_RedoMouseClicked
        // Redoes the undone action
        redo();
    }//GEN-LAST:event_jButton_RedoMouseClicked

    private void jMenuItem_ExitMouseClicked() {//GEN-FIRST:event_jMenuItem_ExitMouseClicked
        // Closes the program
        exit();
    }//GEN-LAST:event_jMenuItem_ExitMouseClicked

    private void jMenuItem_NewFileActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_NewFileActionPerformed
        // Generates a new file
        newFile();
    }//GEN-LAST:event_jMenuItem_NewFileActionPerformed

    private void jMenuItem_OpenFileActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_OpenFileActionPerformed
        // Opens a file
        openFile();
    }//GEN-LAST:event_jMenuItem_OpenFileActionPerformed

    private void jMenuItem_SaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SaveActionPerformed
        // Saves a file
        saveFile();
    }//GEN-LAST:event_jMenuItem_SaveActionPerformed

    private void jMenuItem_SaveAsActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SaveAsActionPerformed
        // Saves a file in the chosen path
        saveFileAs();
    }//GEN-LAST:event_jMenuItem_SaveAsActionPerformed

    private void jMenuItem_ExitActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ExitActionPerformed
        // Closes the program
        exit();
    }//GEN-LAST:event_jMenuItem_ExitActionPerformed

    private void jMenuItem_UndoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_UndoActionPerformed
        // Goes one action back
        undo();
    }//GEN-LAST:event_jMenuItem_UndoActionPerformed

    private void jMenuItem_RedoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_RedoActionPerformed
        // Redoes the undone action
        redo();
    }//GEN-LAST:event_jMenuItem_RedoActionPerformed

    private void formWindowClosing() {//GEN-FIRST:event_formWindowClosing
        // Closes the program
        exit();
    }//GEN-LAST:event_formWindowClosing

    private void jMenu_HelpMouseClicked() {//GEN-FIRST:event_jMenu_HelpMouseClicked
        // Displays the help Window if is not opened
        if (!isDialogOpen){
            help();
        }
    }//GEN-LAST:event_jMenu_HelpMouseClicked

    private void jSpinner_fontSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_fontSizeStateChanged
        // Changes the size of the text
        textSizeChanger();
    }//GEN-LAST:event_jSpinner_fontSizeStateChanged

    private void jButton_ColorChangerActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton_ColorChangerActionPerformed
        // Changes the color of the text
        colorChanger();
    }//GEN-LAST:event_jButton_ColorChangerActionPerformed

    private void jComboBox_fontsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_fontsItemStateChanged
        // Changes the font of the text
        textFontChanger();
    }//GEN-LAST:event_jComboBox_fontsItemStateChanged

    private void textAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textAreaMouseReleased
        // Right-Click menu
        if (evt.isPopupTrigger()) {
            jPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_textAreaMouseReleased

    private void jButton_cutActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton_cutActionPerformed
        // Cuts the selected text
        cut();
    }//GEN-LAST:event_jButton_cutActionPerformed

    private void jButton_copyActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton_copyActionPerformed
        // Copies the selected text
        copy();
    }//GEN-LAST:event_jButton_copyActionPerformed

    private void jButton_pasteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton_pasteActionPerformed
        // Pastes the clipboard's text
        paste();
    }//GEN-LAST:event_jButton_pasteActionPerformed

    private void jMenuItem_CutActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CutActionPerformed
        // Cuts the selected text
        cut();
    }//GEN-LAST:event_jMenuItem_CutActionPerformed

    private void jMenuItem_CopyActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CopyActionPerformed
        // Copies the selected text
        copy();
    }//GEN-LAST:event_jMenuItem_CopyActionPerformed

    private void jMenuItem_PasteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_PasteActionPerformed
        // Pastes the clipboard's text
        paste();
    }//GEN-LAST:event_jMenuItem_PasteActionPerformed

    private void jMenuItem_clickUndoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_clickUndoActionPerformed
        // Goes one action back
        undo();
    }//GEN-LAST:event_jMenuItem_clickUndoActionPerformed

    private void jMenuItem_rightClickRedoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_rightClickRedoActionPerformed
        // Redoes the undone action
        redo();
    }//GEN-LAST:event_jMenuItem_rightClickRedoActionPerformed

    private void jMenuItem_rightClickCutActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_rightClickCutActionPerformed
        // Cuts the selected text
        cut();
    }//GEN-LAST:event_jMenuItem_rightClickCutActionPerformed

    private void jMenuItem_rightClickCopyActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_rightClickCopyActionPerformed
        // Copies the selected text
        copy();
    }//GEN-LAST:event_jMenuItem_rightClickCopyActionPerformed

    private void jMenuItem_rightClickPasteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem_rightClickPasteActionPerformed
        // Pastes the clipboard's text
        paste();
    }//GEN-LAST:event_jMenuItem_rightClickPasteActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File themes = new File("src/mian/java/themes");
        FlatLaf.registerCustomDefaultsSource(themes);
        MiTema.setup();
        java.awt.EventQueue.invokeLater(() -> new MainWindow().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JFileChooser fileChooser;
    private javax.swing.JButton jButton_ColorChanger;
    private javax.swing.JButton jButton_Help;
    private javax.swing.JButton jButton_NewFile;
    private javax.swing.JButton jButton_OpenFile;
    private javax.swing.JButton jButton_Redo;
    private javax.swing.JButton jButton_SaveFile;
    private javax.swing.JButton jButton_copy;
    private javax.swing.JButton jButton_cut;
    private javax.swing.JButton jButton_paste;
    private javax.swing.JButton jButton_undo;
    private javax.swing.JComboBox<String> jComboBox_fonts;
    private javax.swing.JLabel jLabel_characters;
    private javax.swing.JLabel jLabel_lines;
    private javax.swing.JLabel jLabel_words;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JSpinner jSpinner_fontSize;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

    /**
     * Initializes the fonts to be displayed in the combo box, and selects the
     * "Verdana" font.
     */
    private void otherInits() {
        for (String fontName : fontNames) {
            jComboBox_fonts.addItem(fontName);
        }

        // set Verdana as default
        jComboBox_fonts.setSelectedItem("Verdana");

        // Create a file handler to write logs to a file
        try {
            // Set up the logger
            FileHandler fileHandler = new FileHandler("/logs/logger.log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL);
        } catch (IOException | SecurityException e) {
            LOGGER.severe(e.getLocalizedMessage());
        }
    }

    /**
     * Adds a key binding for a specified key stroke, action key, and action.
     *
     * @param keyStroke the key stroke to be added
     * @param actionKey the action key to be added
     * @param action the action to be added
     */
    private void addKeyBinding(KeyStroke keyStroke, String actionKey, Action action) {
        textArea.getInputMap().put(keyStroke, actionKey);
        textArea.getActionMap().put(actionKey, action);
    }

    /**
     * Adds key bindings for the "New", "Open", "Save", "Save As", "Cut",
     * "Copy", and "Paste" actions.
     */
    private void keyEvents() {

        addKeyBinding(KeyStroke.getKeyStroke("control N"), "new", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Code to create a new document
                newFile();
            }
        });
        addKeyBinding(KeyStroke.getKeyStroke("control O"), "open", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Code to open a document
                openFile();
            }
        });
        addKeyBinding(KeyStroke.getKeyStroke("control S"), "save", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Code to save the document
                saveFile();
            }
        });
        addKeyBinding(KeyStroke.getKeyStroke("control shift S"), "saveAs", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Code to save the document as a new file
                saveFileAs();
            }
        });
        addKeyBinding(KeyStroke.getKeyStroke("control X"), "cut", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Code to cut the selection
                cut();
            }
        });
        addKeyBinding(KeyStroke.getKeyStroke("control C"), "copy", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Code to copy the selection
                copy();
            }
        });
        addKeyBinding(KeyStroke.getKeyStroke("control V"), "paste", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Code to paste form the clipboard
                paste();
            }
        });
    }

    /**
     * Cuts the selected text and puts it on the clipboard.
     */
    private void cut() {
        String selectedText = textArea.getSelectedText();
        if (selectedText != null) {
            StringSelection selection = new StringSelection(selectedText);
            clipboard.setContents(selection, selection);
            textArea.replaceSelection("");
        }
    }

    /**
     * Copies the selected text to the clipboard.
     */
    private void copy() {
        String selectedText = textArea.getSelectedText();
        if (selectedText != null) {
            StringSelection selection = new StringSelection(selectedText);
            clipboard.setContents(selection, null);
        }
    }

    /**
     * Pastes the clipboard contents into the text area.
     */
    private void paste() {
        if (textArea.getSelectedText() != null) {
            textArea.replaceSelection("");
        }
        int caretPosition = textArea.getCaretPosition();
        Transferable contents = clipboard.getContents(null);
        if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                String text = (String) contents.getTransferData(DataFlavor.stringFlavor);
                textArea.insert(text, caretPosition);
            } catch (UnsupportedFlavorException | IOException ex) {
                LOGGER.severe(ex.getLocalizedMessage());
                errorMessage(ex.getMessage());
            }
        }
    }

    /**
     *
     * Method to undo the last change made in the text area. If the undoManager
     * can undo the last change, it undoes it.
     */
    private void undo() {
        if (undoManager.canUndo()) {
            undoManager.undo();
        }
    }

    /**
     *
     * Method to redo the last change made in the text area. If the undoManager
     * can redo the last change, it redoes it.
     */
    private void redo() {
        if (undoManager.canRedo()) {
            undoManager.redo();
        }
    }

    /**
     *
     * Method to create key bindings for the undo and redo actions. It creates
     * key strokes for "control Z" and "control Y" respectively. It maps these
     * key strokes to "undoKeyStroke" and "redoKeyStroke". It adds an action to
     * the text area for each of these key strokes. When the action is
     * triggered, it calls the undo() or redo() method respectively.
     */
    private void undoRedo() {
        // Create key bindings for undo and redo actions
        KeyStroke undoKeyStroke = KeyStroke.getKeyStroke("control Z");
        KeyStroke redoKeyStroke = KeyStroke.getKeyStroke("control Y");
        textArea.getInputMap().put(undoKeyStroke, "undoKeyStroke");
        textArea.getInputMap().put(redoKeyStroke, "redoKeyStroke");
        textArea.getActionMap().put("undoKeyStroke", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                undo();
            }
        });
        textArea.getActionMap().put("redoKeyStroke", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                redo();
            }
        });
    }

    /**
     *
     * Method to display a JColorChooser dialog box and change the text color of
     * the text area. If a color is chosen, it sets the new color as the
     * foreground color of the text area.
     */
    private void colorChanger() {
        Color newColor = JColorChooser.showDialog(this, "Choose Text Color", textArea.getForeground());
        if (newColor != null) {
            textArea.setForeground(newColor);
        }
    }

    /**
     *
     * Method to change the font size of the text area. It retrieves the current
     * font of the text area and sets a new font with the same family, style,
     * and the font size selected from the JSpinner.
     */
    private void textSizeChanger() {
        Font font = textArea.getFont();
        textArea.setFont(new Font(font.getFamily(), font.getStyle(), (int) jSpinner_fontSize.getValue()));
    }

    /**
     * Method to change the font of the text area. It retrieves the font family
     * and font size selected from the JComboBox and JSpinner respectively. It
     * sets a new font with the selected font family, plain style, and font
     * size.
     */
    private void textFontChanger() {
        textArea.setFont(new Font(Objects.requireNonNull(jComboBox_fonts.getSelectedItem()).toString(), Font.PLAIN, (int) jSpinner_fontSize.getValue()));
    }

    // This is the document being edited. It should be able to change when a different file is selected to edit.
    private Document doc;

    /**
     * Method to count the number of characters, words, and lines in the text
     * area. It adds a DocumentListener to the document of the text area. When
     * the document is changed, it calls the updateCounters() method to update
     * the counters.
     */
    private void elementCounter() {
        doc = textArea.getDocument();
        doc.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent evt) {
                updateCounters();
            }

            @Override
            public void removeUpdate(DocumentEvent evt) {
                updateCounters();
            }

            @Override
            public void changedUpdate(DocumentEvent evt) {
                // This is only called for styled documents, which we're not using here.
            }

        });
    }

    /**
     * Updates the counters for the number of lines, characters, and words in
     * the text area. Displays the updated values in the corresponding labels.
     */
    private void updateCounters() {
        int numLines = textArea.getLineCount();
        int numChars = doc.getLength();
        int numWords = textArea.getText().split("\\s+").length;
        jLabel_characters.setText("Characters: " + numChars);
        if (numChars == 0) {
            jLabel_words.setText("Words: 0");
            jLabel_lines.setText("Lines: 0");
        } else if (numChars > 0) {
            jLabel_words.setText("Words: " + numWords);
            jLabel_lines.setText("Lines: " + numLines);
        }
        textChanged = true;
    }

    /**
     * Creates a new file. If the text in the current file has been changed,
     * prompts the user to save the changes. Clears the text area and sets the
     * window title to "Untitled - Text Editor".
     *
     */
    private void newFile() {
        if (textChanged) {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to save changes to this file?", "Text Editor",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                saveFile();
            } else if (option == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        setTitle("Untitled - Text Editor");
        textArea.setText("");
        textChanged = false;
    }

    /**
     *
     * Disables or enables all tools in the application.
     *
     * @param bool If true, enables all tools. If false, disables all tools.
     */
    private void enableTools(Boolean bool) {
        jMenuBar.setEnabled(bool);
        jButton_ColorChanger.setEnabled(bool);
        jButton_Help.setEnabled(bool);
        jButton_NewFile.setEnabled(bool);
        jButton_OpenFile.setEnabled(bool);
        jButton_Redo.setEnabled(bool);
        jButton_SaveFile.setEnabled(bool);
        jButton_copy.setEnabled(bool);
        jButton_cut.setEnabled(bool);
        jButton_paste.setEnabled(bool);
        jButton_undo.setEnabled(bool);
        this.setResizable(bool);
    }

    /**
     *
     * Opens a file for editing. If the file has unsaved changes, prompts the
     * user to save them first.
     */
    private void openFile() {
        if (textChanged) {
// Prompt the user to save changes before opening the new file
            int option = JOptionPane.showConfirmDialog(this, "Do you want to save changes to this file?", "Text Editor",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                saveFile();
            } else if (option == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
// Set the file filter to show only text files
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            enableTools(false);
            File file = fileChooser.getSelectedFile();
            // limit 3%
            long limit = limitRAM();
            long fileSize = file.length();
            if (fileSize < limit) {
                if (!file.getName().toLowerCase().endsWith(".txt")) {
                    file = new File(file.getParentFile(), file.getName() + ".txt");
                }
                setTitle(file.getName() + " - Text Editor");
                this.openedFile = file;
                try {
                    FileReader fileReader = new FileReader(file);
                    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                        textArea.read(bufferedReader, null);
                        elementCounter();
                        doc = textArea.getDocument();
                        updateCounters();
                    }
                } catch (IOException evt) {
                    LOGGER.severe(evt.getLocalizedMessage());
                    errorMessage(evt.getMessage());
                    newFile();
                }
                textChanged = false;
            } else {
                String fileTooBig = "Tried to open a " + (fileSize / (1024 * 1024)) + "Mb file being the limit " + (limit / (1024 * 1024)) + "Mb.\n";
                LOGGER.fine(fileTooBig);
                errorMessage("Can not open this file because is to big.\nThe file is " + (fileSize / (1024 * 1024)) + "Mb.\nYour actual limit is " + (limit / (1024 * 1024)) + "Mb.");
            }
// Enable the tools for editing
            enableTools(true);
        }
    }

    /**
     *
     * Saves the current opened file. If the file has not been saved yet,
     * prompts the user to choose a file name and location.
     */
    private void saveFile() {
        if (getTitle().equals("Untitled - Text Editor")) {
            saveFileAs();
        } else {
            File file = openedFile;
            try {
                FileWriter fileWriter = new FileWriter(file);
                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    textArea.write(bufferedWriter);
                }
            } catch (IOException evt) {
                LOGGER.severe(evt.getLocalizedMessage());
                errorMessage(evt.getMessage());
            }
            textChanged = false;
        }
    }

    /**
     *
     * Displays a save dialog and saves the contents of the text area to a file.
     * <p>
     * If the file already exists, prompts the user if they want to overwrite
     * it.
     * <p>
     * Sets the title of the text editor to the name of the saved file.
     */
    private void saveFileAs() {
        int option = fileChooser.showSaveDialog(this);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file.exists()) {
                int existMessage = JOptionPane.showConfirmDialog(this, "This file already exists. Do you want to overwrite it?", "Text Editor",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (existMessage == JOptionPane.CANCEL_OPTION) {
                    return;
                } else if (existMessage == JOptionPane.NO_OPTION) {
                    return;
                }
            }
            setTitle(file.getName() + " - Text Editor");
            openedFile = file;
            try {
                FileWriter fileWriter = new FileWriter(file);
                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    textArea.write(bufferedWriter);
                }
            } catch (IOException evt) {
                LOGGER.severe(evt.getLocalizedMessage());
                errorMessage(evt.getMessage());
            }
            textChanged = false;

        }
    }

    private boolean isDialogOpen = false;

    /**
     *
     * Displays the help dialog.
     */
    private void help() {
        Help helpDialog = new Help(this, false);
        helpDialog.setModalityType(Dialog.ModalityType.MODELESS);
        helpDialog.setTitle("Help");
        isDialogOpen = true;
        helpDialog.setVisible(true);
    }

    public void helpWindowClosed() {
        isDialogOpen = false;
    }

    /**
     *
     * Prompts the user to save changes to the current file before exiting. If
     * the user chooses to save, calls the saveFile method. Disposes of the text
     * editor window.
     */
    private void exit() {
        if (textChanged) {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to save changes to this file?", "Text Editor",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                saveFile();
            } else if (option == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        dispose();
    }

    /**
     *
     * Returns the maximum amount of memory available to the JVM.
     * <p> <p>
     * Calculates the maximum file size that can be opened based on the
     * available memory.
     * <p>
     * Sets the maximum file size to be 3% of the available memory.
     *
     * @return The maximum file size that can be opened, in bytes.
     */
    private long limitRAM() {
        // Get the maximum amount of memory available to the JVM
        long maxMemory = Runtime.getRuntime().maxMemory();

        // Calculate the maximum file size based on the available memory
        // set the maximum file size to be 3% of the available memory
        return (long) (maxMemory * 0.03);
    }

    /**
     *
     * Displays an error message in a dialog box with the given message.
     *
     * @param errorMessage The error message to display.
     */
    private void errorMessage(String errorMessage) {
        JOptionPane.showConfirmDialog(this, "An error ocurred: \n\n" + errorMessage, "Text Editor",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
    }
}
