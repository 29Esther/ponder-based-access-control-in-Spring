package com.ecs235.ponder;

/* Generated By:JJTree: Do not edit this line. ASTDomainScopeExpression.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTDomainScopeExpression extends SimpleNode {
  public ASTDomainScopeExpression(int id) {
    super(id);
  }

  public ASTDomainScopeExpression(Ponder p, int id) {
    super(p, id);
  }

  private String name;

  public void setName(String n) {
    name = n;
  }

  public String toString() {
    return "Domain: " + name;
  }
}
/* JavaCC - OriginalChecksum=00d89d113d23106184a8d9bd5d04013f (do not edit this line) */
