package com.prinjsystems.prgmgame;

import static com.prinjsystems.prgmgame.MainLoop.intVars;
import static com.prinjsystems.prgmgame.MainLoop.fltVars;
import static com.prinjsystems.prgmgame.MainLoop.bolVars;

public class CompilingUtils {
	
	public static int compileOp(String op, String value, String currValue) {
		int number = 0;
		int result = 0;
		
		boolean var = false;
        String varName = "";
        int varType = 0;
        
        boolean var2 = false;
        String varName2 = "";
        int varType2 = 0;
        
        int currentValue = 0;
        
        for(String a : intVars.keySet()) {
            if(a.equals(value)) {
                var2 = true;
                varName2 = a;
                varType2 = 1;
            }
        }
        if(!var) {
            for(String a : fltVars.keySet()) {
                if(a.equals(value)) {
                    var2 = true;
                    varName2 = a;
                    varType2 = 2;
                }
            }
        }
        
        if(var2) {
        	if(varType2 == 1) {
        		currentValue = intVars.get(varName2);
        	} else if(varType == 2) {
        		float flt = fltVars.get(varName2);	
        		currentValue = (int) flt;
        	}
        } else {
        	System.out.println(currValue);
        	currentValue = Integer.parseInt(currValue);
        }
        
        boolean accValue = false;
		
		if(value.equalsIgnoreCase("acc")) {
			number = MainLoop.getAcc();
			accValue = true;
		} else {
            for(String a : intVars.keySet()) {
                if(a.equals(value)) {
                    var = true;
                    varName = a;
                    varType = 1;
                }
            }
            if(!var) {
                for(String a : fltVars.keySet()) {
                    if(a.equals(value)) {
                        var = true;
                        varName = a;
                        varType = 2;
                    }
                }
            }
            if(!var) {
                for(String a : bolVars.keySet()) {
                    if(a.equals(value)) {
                        var = true;
                        varName = a;
                        varType = 3;
                    }
                }
            }
		}
		
		if(!var && !accValue) {
			number = Integer.parseInt(value);
		} else if(var && !accValue) {
			if(varType == 1) {
				number = intVars.get(varName);
			} else if(varType == 2) {
				float flt = fltVars.get(varName);
				number = (int) flt;
			} else if(varType == 3) {
				boolean b = bolVars.get(varName);
				
				if(b == true) {
					number = 1;
				} else {
					number = 2;
				}
			}
		}
		
		if(op.equalsIgnoreCase("notis")) {
			result = notIs(number, currentValue);
		} else if(op.equalsIgnoreCase("less")) {
			result = lessThan(number, currentValue);
		} else if(op.equalsIgnoreCase("greather")) {
			result = greatherThan(number, currentValue);
		} else if(op.equalsIgnoreCase("lessequal")) {
			result = lessOrEqualThan(number, currentValue);
		} else if(op.equalsIgnoreCase("greatherequal")) {
			result = greatherOrEqualThan(number, currentValue);
		}
		
		return result;
	}
	
	public static int notIs(int valueToNotReach, int currentValue) {
		int value = 0;
		
		//System.out.println(currentValue);
		
		if(currentValue != valueToNotReach) {
			value = currentValue;
		}
		
		return value;
	}
	
	public static int lessThan(int capValue, int currentValue) {
		int value = 0;
		
		if(currentValue < capValue) {
			value = currentValue;
		}
		
		return value;
	}
	
	public static int greatherThan(int baseValue, int currentValue) {
		int value = 0;
		
		if(currentValue > baseValue) {
			value = currentValue;
		}
		
		return value;
	}
	
	public static int lessOrEqualThan(int capValue, int currentValue) {
		int value = 0;
		
		if(currentValue <= capValue) {
			value = currentValue;
		}
		
		return value;
	}
	
	public static int greatherOrEqualThan(int baseValue, int currentValue) {
		int value = 0;
		
		if(currentValue >= baseValue) {
			value = currentValue;
		}
		
		return value;
	}
}
