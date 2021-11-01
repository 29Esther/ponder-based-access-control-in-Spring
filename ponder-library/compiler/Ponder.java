package com.ecs235.ponder;/* Ponder.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. Ponder.java */
/**
 * An Arithmetic Grammar.
 */
public class Ponder/*@bgen(jjtree)*/implements PonderTreeConstants, PonderConstants {/*@bgen(jjtree)*/
  protected static JJTPonderState jjtree = new JJTPonderState();
  /** Main entry point. */
  public static void main(String args[]) {
    System.out.println("Reading from standard input...");
    Ponder t = new Ponder(System.in);
    try {
      SimpleNode n = t.Start();
      n.dump("");
      System.out.println("Thank you.");
    } catch (Exception e) {
      System.out.println("Oops.");
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

/** Main production. */
  static final public SimpleNode Start() throws ParseException {/*@bgen(jjtree) Start */
  ASTStart jjtn000 = new ASTStart(JJTSTART);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      AuthStatement();
      jj_consume_token(0);
jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
{if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
    throw new Error("Missing return statement in function");
}

/** auth policy */
  static final public 
void PolicyName() throws ParseException {/*@bgen(jjtree) PolicyName */
  ASTPolicyName jjtn000 = new ASTPolicyName(JJTPOLICYNAME);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(STRING);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  static final public void DomainScopeExpression() throws ParseException {/*@bgen(jjtree) DomainScopeExpression */
    ASTDomainScopeExpression jjtn000 = new ASTDomainScopeExpression(JJTDOMAINSCOPEEXPRESSION);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(DOMAIN);
jjtree.closeNodeScope(jjtn000, true);
     jjtc000 = false;
jjtn000.setName(t.image);
    } finally {
if (jjtc000) {
       jjtree.closeNodeScope(jjtn000, true);
     }
    }
}

  static final public void ActionItem() throws ParseException {/*@bgen(jjtree) ActionItem */
    ASTActionItem jjtn000 = new ASTActionItem(JJTACTIONITEM);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(ACTIONITEM);
jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
jjtn000.setName(t.image);
    } finally {
if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
}

  static final public void ActionList() throws ParseException {/*@bgen(jjtree) ActionList */
  ASTActionList jjtn000 = new ASTActionList(JJTACTIONLIST);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      ActionItem();
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case COMMA:{
          ;
          break;
          }
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        jj_consume_token(COMMA);
        ActionItem();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  static final public void ConstraintExpression() throws ParseException {/*@bgen(jjtree) ConstraintExpression */
  ASTConstraintExpression jjtn000 = new ASTConstraintExpression(JJTCONSTRAINTEXPRESSION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(STRING);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  static final public void Instance() throws ParseException {/*@bgen(jjtree) Instance */
  ASTInstance jjtn000 = new ASTInstance(JJTINSTANCE);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(INSTANCE);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  static final public void AuthPlus() throws ParseException {/*@bgen(jjtree) AuthPlus */
  ASTAuthPlus jjtn000 = new ASTAuthPlus(JJTAUTHPLUS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(AUTHPlUS);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  static final public void AuthMinus() throws ParseException {/*@bgen(jjtree) AuthMinus */
  ASTAuthMinus jjtn000 = new ASTAuthMinus(JJTAUTHMINUS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(AUTHMINUS);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  static final public void Type() throws ParseException {/*@bgen(jjtree) Type */
    ASTType jjtn000 = new ASTType(JJTTYPE);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(TYPE);
jjtree.closeNodeScope(jjtn000, true);
     jjtc000 = false;
jjtn000.setName(t.image);
    } finally {
if (jjtc000) {
       jjtree.closeNodeScope(jjtn000, true);
     }
    }
}

  static final public void Subject() throws ParseException {/*@bgen(jjtree) Subject */
  ASTSubject jjtn000 = new ASTSubject(JJTSUBJECT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(SUBJECT);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TYPE:{
        Type();
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        ;
      }
      DomainScopeExpression();
      jj_consume_token(SEMICOLON);
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  static final public void Target() throws ParseException {/*@bgen(jjtree) Target */
  ASTTarget jjtn000 = new ASTTarget(JJTTARGET);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(TARGET);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TYPE:{
        Type();
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        ;
      }
      DomainScopeExpression();
      jj_consume_token(SEMICOLON);
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  static final public void Action() throws ParseException {/*@bgen(jjtree) Action */
  ASTAction jjtn000 = new ASTAction(JJTACTION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(ACTION);
      ActionList();
      jj_consume_token(SEMICOLON);
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  static final public void When() throws ParseException {/*@bgen(jjtree) When */
  ASTWhen jjtn000 = new ASTWhen(JJTWHEN);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(WHEN);
      ConstraintExpression();
      jj_consume_token(SEMICOLON);
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  static final public void PolicyContent() throws ParseException {/*@bgen(jjtree) PolicyContent */
  ASTPolicyContent jjtn000 = new ASTPolicyContent(JJTPOLICYCONTENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Subject();
      Target();
      Action();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case WHEN:{
        When();
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  static final public void AuthStatement() throws ParseException {/*@bgen(jjtree) AuthStatement */
  ASTAuthStatement jjtn000 = new ASTAuthStatement(JJTAUTHSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Instance();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case AUTHPlUS:{
        AuthPlus();
        break;
        }
      case AUTHMINUS:{
        AuthMinus();
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      PolicyName();
      jj_consume_token(LCURLYBRACE);
      PolicyContent();
      jj_consume_token(RCURLYBRACE);
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public PonderTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[5];
  static private int[] jj_la1_0;
  static {
	   jj_la1_init_0();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x20000,0x200000,0x200000,0x2000,0x300,};
	}

  /** Constructor with InputStream. */
  public Ponder(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Ponder(java.io.InputStream stream, String encoding) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser.  ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new PonderTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Ponder(java.io.Reader stream) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new PonderTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new PonderTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Ponder(PonderTokenManager tm) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(PonderTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  static private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[25];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 5; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 25; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  static private boolean trace_enabled;

/** Trace enabled. */
  static final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
