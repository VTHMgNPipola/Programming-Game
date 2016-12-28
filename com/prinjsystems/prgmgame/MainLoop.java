package com.prinjsystems.prgmgame;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.prinjsystems.prgmgame.swing.CodingFrame;

public class MainLoop {

    private static int acc;
    
    public static Map<String, String> strVars = new HashMap<>();
    public static Map<String, Integer> intVars = new HashMap<>();
    public static Map<String, Float> fltVars = new HashMap<>();
    public static Map<String, Boolean> bolVars = new HashMap<>();
    
    public static boolean isReading = false;
    
    private static CodingFrame frame = new CodingFrame();
    
    private static List<String> commands = new ArrayList<>();

    public MainLoop() {
        acc = 0;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Programming Game!");
        System.out.println("A game when you create the game!");

//        boolean running = true;
//
//        Scanner scn = new Scanner(System.in);
//        
//        List<String> runnedCode = new ArrayList<>();
//        Map<String, List<String>> commandFiles = new HashMap<>();
//
//        int lineNumber = 0;
        
        PrintStream ps = new PrintStream(new CustomOutputStream(frame.textArea));
        
        System.setOut(ps);
        System.setErr(ps);
        
        frame.setVisible(true);
        
//        while(running) {
//        	
//        	
//            if(lineNumber <= 9) {
//                System.out.print(lineNumber + " |");
//            } else {
//                System.out.print(lineNumber + "|");
//            }
//            
//            String cmd = scn.nextLine();
//
//            if(cmd.equals("run")) {
//                runCode();
//                runnedCode = commands;
//                commands = new ArrayList<>();
//                lineNumber = 0;
//                System.gc();
//            } else if(cmd.equals("exit")) {
//                running = false;
//                System.out.println("Goodbye!");
//            } else if(cmd.contains("save ")) {
//                String[] s = cmd.split(" ");
//
//                commandFiles.put(s[1], commands);
//                System.out.println("Save complete!");
//            } else if(cmd.contains("load")) {
//                String[] s = cmd.split(" ");
//                
//                if(s.length > 1) {
//                    commands = commandFiles.get(s[1]);
//                } else {
//                    commands = runnedCode;
//                }
//                System.out.println("Load complete!");
//            } else if(cmd.equals("ls")) {
//                for (String s : commandFiles.keySet()) {
//                    System.out.println(s);
//                }
//            } else if(cmd.equals("code")) {
//                for(int i = 0; i < commands.size(); i++) {
//                    System.out.println(i + "|" + commands.get(i));
//                }
//            } else if(cmd.contains("edit ")) {
//            	String[] s = cmd.split(" ");
//            	
//            	String value = "";
//            	
//            	if(Integer.parseInt(s[1]) <= 9) {
//            		value = cmd.substring(7);
//            	} else {
//            		value = cmd.substring(8);
//            	}
//            	
//            	commands.set(Integer.parseInt(s[1]), value);
//            }
//            
//            else {
//                commands.add(cmd);
//                lineNumber++;
//            }
//        }
//
//        scn.close();
    }

    public static void runCode() {
    	int gotoRepetions = -1;
    	int gotoCurrent = 1;
    	
    	Scanner scn = new Scanner(System.in);
    	
        try {
            for(int i = 0; i < commands.size(); i++) {
                String cmd = commands.get(i);
                String[] s = cmd.split(" ");

                /*
                 *
                 * Print method
                 *
                 */
                if(cmd.matches("print .* ;") || cmd.matches("print .*")) {
                    boolean var = false;
                    String varName = "";
                    int varType = 0;

                    for(String a : strVars.keySet()) {
                        if(a.equals(s[1])) {
                            var = true;
                            varName = a;
                            varType = 1;
                        }
                    }
                    if(!var) {
                        for(String a : intVars.keySet()) {
                            if(a.equals(s[1])) {
                                var = true;
                                varName = a;
                                varType = 2;
                            }
                        }
                    }
                    if(!var) {
                        for(String a : fltVars.keySet()) {
                            if(a.equals(s[1])) {
                                var = true;
                                varName = a;
                                varType = 3;
                            }
                        }
                    }
                    if(!var) {
                        for(String a : bolVars.keySet()) {
                            if(a.equals(s[1])) {
                                var = true;
                                varName = a;
                                varType = 4;
                            }
                        }
                    }

                    if(!s[1].equalsIgnoreCase("acc") && !var) {
                        String result = cmd.substring(6);

                        System.out.print(result);
                    } else if(!var) {
                        System.out.print(acc);
                    } else {
                        if(varType == 1) {
                            System.out.print(strVars.get(varName));
                        } else if(varType == 2) {
                            System.out.print(intVars.get(varName));
                        } else if(varType == 3) {
                            System.out.print(fltVars.get(varName));
                        } else if(varType == 4) {
                            System.out.print(bolVars.get(varName));
                        }
                    }
                } /*
                 *
                 * Println method
                 *
                 */
                else if(cmd.matches("println .* ;") || cmd.matches("println .*")) {
                    boolean var = false;
                    String varName = "";
                    int varType = 0;

                    for(String a : strVars.keySet()) {
                        if (a.equals(s[1])) {
                            var = true;
                            varName = a;
                            varType = 1;
                        }
                    }
                    if(!var) {
                        for(String a : intVars.keySet()) {
                            if(a.equals(s[1])) {
                                var = true;
                                varName = a;
                                varType = 2;
                            }
                        }
                    }
                    if(!var) {
                        for(String a : fltVars.keySet()) {
                            if(a.equals(s[1])) {
                                var = true;
                                varName = a;
                                varType = 3;
                            }
                        }
                    }
                    if(!var) {
                        for(String a : bolVars.keySet()) {
                            if(a.equals(s[1])) {
                                var = true;
                                varName = a;
                                varType = 4;
                            }
                        }
                    }

                    if(!s[1].equalsIgnoreCase("acc") && !var) {
                        String result = cmd.substring(8);

                        System.out.println(result);
                    } else if(!var) {
                        System.out.println(acc);
                    } else {
                        if(varType == 1) {
                            System.out.println(strVars.get(varName));
                        } else if(varType == 2) {
                            System.out.println(intVars.get(varName));
                        } else if(varType == 3) {
                            System.out.println(fltVars.get(varName));
                        } else if(varType == 4) {
                            System.out.println(bolVars.get(varName));
                        }
                    }
                }
                /*
                 * Finish of the println method
                 */
                else if(cmd.contains("mov ")) {
                    if (isStringVar(strVars, s[2])) {
                        strVars.put(s[2], s[1]);
                    } else if(isIntegerVar(intVars, s[2])) {
                        intVars.put(s[2], (int) getValue(s[1]));
                    } else if(isFloatVar(fltVars, s[2])) {
                        fltVars.put(s[2], getValue(s[1]));
                    } else if(isBooleanVar(bolVars, s[2])) {
                        bolVars.put(s[2], Boolean.parseBoolean(s[1]));
                    } else {
                        acc = Integer.parseInt(s[1]);
                    }
                } else if(cmd.contains("add ")) {
                    if(s.length > 2) {
                    	compile(s[1], s[2], 0);
                    } else {
                        acc += Integer.parseInt(s[1]);
                    }
                } else if(cmd.contains("sub ")) {
                    if(s.length > 2) {
                        compile(s[1], s[2], 1);
                    } else {
                        acc -= Integer.parseInt(s[1]);
                    }
                } else if(cmd.contains("mlt ")) {
                    if(s.length > 2) {
                        compile(s[1], s[2], 2);
                    } else {
                        acc -= Integer.parseInt(s[1]);
                    }
                } else if(cmd.contains("div ")) {
                    if(s.length > 2) {
                        compile(s[1], s[2], 3);
                    } else {
                        acc /= getValue(s[1]);
                    }
                } else if(cmd.contains("string ")) {
                    if(cmd.matches("string .* = .*")) {
                        String result = "";

                        for (int id = 3; id < s.length; id++) {
                            result += s[id] + " ";
                        }

                        result = result.substring(0, result.length() - 1);

                        if (cmd.endsWith(" ")) {
                            result += " ";
                        }

                        strVars.put(s[1], result);
                    } else {
                        strVars.put(s[1], "");
                    }
                } else if(cmd.contains("int ")) {
                    if (cmd.matches("int .* = .*")) {
                        intVars.put(s[1], Integer.parseInt(s[3]));
                    } else {
                        intVars.put(s[1], 0);
                    }
                } else if(cmd.contains("float ")) {
                    if (cmd.matches("float .* = .*")) {
                        fltVars.put(s[1], Float.parseFloat(s[3]));
                    } else {
                        fltVars.put(s[1], 0.0f);
                    }
                } else if(cmd.contains("boolean ")) {
                    if (cmd.matches("boolean .* = .*")) {
                        bolVars.put(s[1], Boolean.parseBoolean(s[3]));
                    } else {
                        bolVars.put(s[1], false);
                    }
                } else if(cmd.matches("goto .* .* times")) {
                	if(gotoRepetions != 0 && gotoCurrent < gotoRepetions) {
                		i = Integer.parseInt(s[1]) - 1;
                		gotoCurrent++;
                	} else if(gotoRepetions == -1) {
                		gotoRepetions = Integer.parseInt(s[2]);
                		i = Integer.parseInt(s[1]) - 1;
                		gotoCurrent++;
                	} else if(gotoRepetions == gotoCurrent) {
                		gotoCurrent = 1;
                		gotoRepetions = -1;
                	} else if(gotoRepetions == 0) {
                		i = Integer.parseInt(s[1]) - 1;
                		gotoCurrent = 1;
                	}
                } else if(cmd.contains("stopfor ")) {
                    try {
                        Thread.sleep(Integer.parseInt(s[1]));
                    } catch(InterruptedException ex) {
                        System.err.println("An error ocurred! System can't comple"
                                + "te stopfor action!");
                    }
                } else if(cmd.equals("newline")) {
                	System.out.println();
                } else if(cmd.equals("clear")) {
                	frame.textArea.setText("");
                } else if(cmd.contains("read ")) {
                	String varName = "";
                	
                	for(String str : strVars.keySet()) {
                		if(str.equals(s[1])) {
                			varName = str;
                		}
                	}
                	
                	isReading = true;
                	frame.setRead(true);
                	String str = scn.nextLine();
                	isReading = false;
                	frame.setRead(false);
                	
                	strVars.put(varName, str);
                }
                
                else {
                    System.out.println("Command not recognized! Command: " + cmd);
                }
            }
            
            System.out.println();
            System.out.println("Execution Successful!");
        } catch(Exception e) {
            System.err.println("An error ocurred on execution!");
            e.printStackTrace();
        }
        
        scn.close();
    }

    public static boolean isStringVar(Map<String, String> strVars, String var) {
        return strVars.get(var) != null;
    }

    public static boolean isIntegerVar(Map<String, Integer> intVars, String var) {
        return intVars.get(var) != null;
    }

    public static boolean isFloatVar(Map<String, Float> fltVars, String var) {
        return fltVars.get(var) != null;
    }

    public static boolean isBooleanVar(Map<String, Boolean> bolVars, String var) {
        return bolVars.get(var) != null;
    }
    
    public static float getValue(String key) {
        float value = 0;
        
        boolean var = false;
        String varName = "";
        int varType = 0;

        for(String a : strVars.keySet()) {
            if(a.equals(key)) {
                var = true;
                varName = a;
                varType = 1;
            }
        }
        if(!var) {
            for(String a : intVars.keySet()) {
                if(a.equals(key)) {
                    var = true;
                    varName = a;
                    varType = 2;
                }
            }
        }
        if(!var) {
            for(String a : fltVars.keySet()) {
                if(a.equals(key)) {
                    var = true;
                    varName = a;
                    varType = 3;
                }
            }
        }
        if(!var) {
            for(String a : bolVars.keySet()) {
                if(a.equals(key)) {
                    var = true;
                    varName = a;
                    varType = 4;
                }
            }
        }
        
        if(key.equalsIgnoreCase("acc")) {
            value = acc;
        } else if(var) {
            if(varType == 1) {
                value = Integer.parseInt(strVars.get(varName));
            } else if(varType == 2) {
                value = intVars.get(varName);
            } else if(varType == 3) {
                float flt = fltVars.get(key);
                value = (int) flt;
            } else if(varType == 4) {
                if(bolVars.get(key) == true) {
                    value = 1;
                } else {
                    value = 0;
                }
            }
        } else {
            value = Integer.parseInt(key);
        }
        
        return value;
    }
    
    public static void compile(String s1, String s2, int op) {
    	if(op == 0) { // Add
    		if(isStringVar(strVars, s2)) {
        		strVars.put(s2, strVars.get(s2) + s1);
        	} else if(isIntegerVar(intVars, s2)) {
        		intVars.put(s2, (int) getValue(s1) + intVars.get(s2));
        	} else if(isFloatVar(fltVars, s2)) {
            	fltVars.put(s2, getValue(s1) + fltVars.get(s2));
        	}
    	}
    	
    	else if(op == 1) { // Sub
    		if(isIntegerVar(intVars, s2)) {
                intVars.put(s2, intVars.get(s2) - (int) getValue(s1));
            } else if(isFloatVar(fltVars, s2)) {
                fltVars.put(s2, fltVars.get(s2) - getValue(s1));
            }
    	}
    	
    	else if(op == 2) { // Mlt
    		if(isIntegerVar(intVars, s2)) {
                intVars.put(s2, intVars.get(s2) * (int) getValue(s1));
            } else if(isFloatVar(fltVars, s2)) {
                fltVars.put(s2, fltVars.get(s2) * getValue(s1));
            }
    	}
    	
    	else if(op == 3) { // Div
    		if(isIntegerVar(intVars, s2)) {
                intVars.put(s2, intVars.get(s2) / (int) getValue(s1));
            } else if(isFloatVar(fltVars, s2)) {
                fltVars.put(s2, fltVars.get(s2) / getValue(s1));
            }
    	}
    }
    
    public static int getAcc() {
    	return acc;
    }
    
    public static void setCode(List<String> code) {
    	commands = code;
    }
}
