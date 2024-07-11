package application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class fillFirst {
	ArrayList<ProductionRule> productions=new ArrayList<ProductionRule>();
	fillFirst(){
		//in the following productions I have added each production and it's firsts
		productions.add(
			    new ProductionRule(
			        new Token("module-decl'"),
			        new ArrayList<Token>(Arrays.asList(
			        		new Token("module-decl"),
			        		new Token("$")
			        )),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("module")
			        ))
			    )
			);
		productions.add(
			    new ProductionRule(
			        new Token("module-decl"),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("module-heading"),
			            new Token("declarations"),
			            new Token("block"),
			            new Token("name"),
			            new Token(".")
			        )),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("module")
			        ))
			    )
			);

		productions.add(
			    new ProductionRule(
			        new Token("module-heading"),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("module"),
			            new Token("name"),
			            new Token(";")
			        )),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("module")
			        ))
			    )
			);
		productions.add(
			    new ProductionRule(
			        new Token("block"),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("begin"),
			            new Token("stmt-list"),
			            new Token("end")
			        )),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("begin")
			        ))
			    )
			);
		productions.add(
			    new ProductionRule(
			        new Token("declarations"),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("const-decl"),
			            new Token("var-decl"),
			            new Token("procedure-decl")
			        )),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("const"),
			            new Token("var"),
			            new Token("procedure"),
			            new Token("begin")
			        ))
			    )
			);
		productions.add(
			    new ProductionRule(
			        new Token("const-decl"),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("const"),
			            new Token("const-list")
			        )),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("const")
			        ))
			    )
			);
		productions.add(
			    new ProductionRule(
			        new Token("const-decl"),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("λ")
			        )),
			        new ArrayList<Token>(Arrays.asList(
				            new Token("var"),
				            new Token("procedure"),
				            new Token("begin")
			        ))
			    )
			);
		productions.add(
			    new ProductionRule(
			        new Token("const-list"),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("name"),
			            new Token("="),
			            new Token("value"),
			            new Token(";"),
			            new Token("const-list")
			        )),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("name")
			        ))
			    )
			);
			productions.add(
			    new ProductionRule(
			        new Token("const-list"),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("λ")
			        )),
			        new ArrayList<Token>(Arrays.asList(
			            new Token("var"),
			            new Token("procedure"),
			            new Token("begin")
			        ))
			    )
			);
			productions.add(
				    new ProductionRule(
				        new Token("var-decl"),
				        new ArrayList<Token>(Arrays.asList(
				            new Token("var"),
				            new Token("var-list")
				        )),
				        new ArrayList<Token>(Arrays.asList(
				            new Token("var")
				        ))
				    )
				);
				productions.add(
				    new ProductionRule(
				        new Token("var-decl"),
				        new ArrayList<Token>(Arrays.asList(
				            new Token("λ")
				        )),
				        new ArrayList<Token>(Arrays.asList(
					            new Token("procedure"),
					            new Token("begin")
				        ))
				    )
				);
				productions.add(
					    new ProductionRule(
					        new Token("var-list"),
					        new ArrayList<Token>(Arrays.asList(
					            new Token("var-item"),
					            new Token(";"),
					            new Token("var-list")
					        )),
					        new ArrayList<Token>(Arrays.asList(
					            new Token("name")
					        ))
					    )
					);
					productions.add(
					    new ProductionRule(
					        new Token("var-list"),
					        new ArrayList<Token>(Arrays.asList(
					            new Token("λ")
					        )),
					        new ArrayList<Token>(Arrays.asList(
					            new Token("procedure"),
					            new Token("begin")
					        ))
					    )
					);
					productions.add(
						    new ProductionRule(
						        new Token("var-item"),
						        new ArrayList<Token>(Arrays.asList(
						            new Token("name-list"),
						            new Token(":"),
						            new Token("data-type")
						        )),
						        new ArrayList<Token>(Arrays.asList(
						            new Token("name")
						        ))
						    )
						);
					productions.add(
						    new ProductionRule(
						        new Token("name-list"),
						        new ArrayList<Token>(Arrays.asList(
						            new Token("name"),
						            new Token("more-names")
						        )),
						        new ArrayList<Token>(Arrays.asList(
						            new Token("name")
						        ))
						    )
						);
					productions.add(
						    new ProductionRule(
						        new Token("more-names"),
						        new ArrayList<Token>(Arrays.asList(
						            new Token(","),
						            new Token("name-list")
						        )),
						        new ArrayList<Token>(Arrays.asList(
						            new Token(",")
						        ))
						    )
						);
						productions.add(
						    new ProductionRule(
						        new Token("more-names"),
						        new ArrayList<Token>(Arrays.asList(
						            new Token("λ")
						        )),
						        new ArrayList<Token>(Arrays.asList(
						            new Token(":"),
						            new Token(")")
						        ))
						    )
						);
						productions.add(
							    new ProductionRule(
							        new Token("data-type"),
							        new ArrayList<Token>(Arrays.asList(
							            new Token("integer")
							        )),
							        new ArrayList<Token>(Arrays.asList(
							            new Token("integer")
							        ))
							    )
							);
							productions.add(
							    new ProductionRule(
							        new Token("data-type"),
							        new ArrayList<Token>(Arrays.asList(
							            new Token("real")
							        )),
							        new ArrayList<Token>(Arrays.asList(
							            new Token("real")
							        ))
							    )
							);
							productions.add(
							    new ProductionRule(
							        new Token("data-type"),
							        new ArrayList<Token>(Arrays.asList(
							            new Token("char")
							        )),
							        new ArrayList<Token>(Arrays.asList(
							            new Token("char")
							        ))
							    )
							);
							productions.add(
								    new ProductionRule(
								        new Token("procedure-decl"),
								        new ArrayList<Token>(Arrays.asList(
								            new Token("procedure-heading"),
								            new Token("declarations"),
								            new Token("block"),
								            new Token("name"),
								            new Token(";"),
								            new Token("procedure-decl")
								        )),
								        new ArrayList<Token>(Arrays.asList(
								            new Token("procedure")
								        ))
								    )
								);
								productions.add(
								    new ProductionRule(
								        new Token("procedure-decl"),
								        new ArrayList<Token>(Arrays.asList(
								            new Token("λ")
								        )),
								        new ArrayList<Token>(Arrays.asList(
								            new Token("begin")
								        ))
								    )
								);
								productions.add(
									    new ProductionRule(
									        new Token("procedure-heading"),
									        new ArrayList<Token>(Arrays.asList(
									            new Token("procedure"),
									            new Token("name"),
									            new Token(";")
									        )),
									        new ArrayList<Token>(Arrays.asList(
									            new Token("procedure")
									        ))
									    )
									);
								productions.add(
									    new ProductionRule(
									        new Token("stmt-list"),
									        new ArrayList<Token>(Arrays.asList(
									            new Token("statement"),
									            new Token(";"),
									            new Token("stmt-list")
									        )),
									        new ArrayList<Token>(Arrays.asList(
										            new Token("name"),
										            new Token(";"),
										            new Token("begin"),
										            new Token("call"),
										            new Token("exit"),
										            new Token("loop"),
										            new Token("while"),
										            new Token("if"),
										            new Token("writeint"),
										            new Token("writereal"),
										            new Token("writechar"),
										            new Token("writeln"),
										            new Token("readint"),
										            new Token("readreal"),
										            new Token("readchar"),
										            new Token("readln")
									        ))
									    )
									);
									productions.add(
									    new ProductionRule(
									        new Token("stmt-list"),
									        new ArrayList<Token>(Arrays.asList(
									            new Token("λ")
									        )),
									        new ArrayList<Token>(Arrays.asList(
									            new Token("else"),
									            new Token("end"),
									            new Token("until")
									        ))
									    )
									);
									productions.add(
										    new ProductionRule(
										        new Token("statement"),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("ass-stmt")
										        )),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("name")
										        ))
										    )
										);
										productions.add(
										    new ProductionRule(
										        new Token("statement"),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("read-stmt")
										        )),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("readint"),
										            new Token("readreal"),
										            new Token("readchar"),
										            new Token("readln")
										        ))
										    )
										);
										productions.add(
										    new ProductionRule(
										        new Token("statement"),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("write-stmt")
										        )),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("writeint"),
										            new Token("writereal"),
										            new Token("writechar"),
										            new Token("writeln")
										        ))
										    )
										);
										productions.add(
										    new ProductionRule(
										        new Token("statement"),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("if-stmt")
										        )),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("if")
										        ))
										    )
										);
										productions.add(
										    new ProductionRule(
										        new Token("statement"),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("while-stmt")
										        )),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("while")
										        ))
										    )
										);
										productions.add(
										    new ProductionRule(
										        new Token("statement"),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("loop-stmt")
										        )),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("loop")
										        ))
										    )
										);
										productions.add(
										    new ProductionRule(
										        new Token("statement"),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("exit-stmt")
										        )),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("exit")
										        ))
										    )
										);
										productions.add(
										    new ProductionRule(
										        new Token("statement"),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("call-stmt")
										        )),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("call")
										        ))
										    )
										);
										productions.add(
										    new ProductionRule(
										        new Token("statement"),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("block")
										        )),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("begin")
										        ))
										    )
										);
										productions.add(
										    new ProductionRule(
										        new Token("statement"),
										        new ArrayList<Token>(Arrays.asList(
										            new Token("λ")
										        )),
										        new ArrayList<Token>(Arrays.asList(
										            new Token(";")
										        ))
										    )
										);
										productions.add(
											    new ProductionRule(
											        new Token("ass-stmt"),
											        new ArrayList<Token>(Arrays.asList(
											            new Token("name"),
											            new Token(":="),
											            new Token("exp")
											        )),
											        new ArrayList<Token>(Arrays.asList(
											            new Token("name")
											        ))
											    )
											);
										productions.add(
											    new ProductionRule(
											        new Token("exp"),
											        new ArrayList<Token>(Arrays.asList(
											            new Token("term"),
											            new Token("exp-prime")
											        )),
											        new ArrayList<Token>(Arrays.asList(
											            new Token("("),
											            new Token("name"),
											            new Token("integer-value"),
											            new Token("real-value")
											        ))
											    )
											);
										productions.add(
											    new ProductionRule(
											        new Token("exp-prime"),
											        new ArrayList<Token>(Arrays.asList(
											            new Token("add-oper"),
											            new Token("term"),
											            new Token("exp-prime")
											        )),
											        new ArrayList<Token>(Arrays.asList(
											            new Token("+"),
											            new Token("-")
											        ))
											    )
											);
											productions.add(
											    new ProductionRule(
											        new Token("exp-prime"),
											        new ArrayList<Token>(Arrays.asList(
											            new Token("λ")
											        )),
											        new ArrayList<Token>(Arrays.asList(
											            new Token(";"),
											            new Token(")")
											        ))
											    )
											);
											productions.add(
												    new ProductionRule(
												        new Token("term"),
												        new ArrayList<Token>(Arrays.asList(
												            new Token("factor"),
												            new Token("term-prime")
												        )),
												        new ArrayList<Token>(Arrays.asList(
													            new Token("("),
													            new Token("name"),
													            new Token("integer-value"),
													            new Token("real-value")
												        ))
												    )
												);
											productions.add(
												    new ProductionRule(
												        new Token("term-prime"),
												        new ArrayList<Token>(Arrays.asList(
												            new Token("mul-oper"),
												            new Token("factor"),
												            new Token("term-prime")
												        )),
												        new ArrayList<Token>(Arrays.asList(
												            new Token("*"),
												            new Token("/"),
												            new Token("mod"),
												            new Token("div")
												        ))
												    )
												);
												productions.add(
												    new ProductionRule(
												        new Token("term-prime"),
												        new ArrayList<Token>(Arrays.asList(
												            new Token("λ")
												        )),
												        new ArrayList<Token>(Arrays.asList(
													            new Token("-"),
													            new Token("+"),
													            new Token(";"),
													            new Token(")")
												        ))
												    )
												);
												productions.add(
													    new ProductionRule(
													        new Token("factor"),
													        new ArrayList<Token>(Arrays.asList(
													            new Token("("),
													            new Token("exp"),
													            new Token(")")
													        )),
													        new ArrayList<Token>(Arrays.asList(
													            new Token("(")
													        ))
													    )
													);
													productions.add(
													    new ProductionRule(
													        new Token("factor"),
													        new ArrayList<Token>(Arrays.asList(
													            new Token("name-value")
													        )),
													        new ArrayList<Token>(Arrays.asList(
													            new Token("name"),
													            new Token("integer-value"),
													            new Token("real-value")
													        ))
													    )
													);
													productions.add(
														    new ProductionRule(
														        new Token("add-oper"),
														        new ArrayList<Token>(Arrays.asList(
														            new Token("+")
														        )),
														        new ArrayList<Token>(Arrays.asList(
														            new Token("+")
														        ))
														    )
														);
														productions.add(
														    new ProductionRule(
														        new Token("add-oper"),
														        new ArrayList<Token>(Arrays.asList(
														            new Token("-")
														        )),
														        new ArrayList<Token>(Arrays.asList(
														            new Token("-")
														        ))
														    )
														);
														productions.add(
															    new ProductionRule(
															        new Token("mul-oper"),
															        new ArrayList<Token>(Arrays.asList(
															            new Token("*")
															        )),
															        new ArrayList<Token>(Arrays.asList(
															            new Token("*")
															        ))
															    )
															);
															productions.add(
															    new ProductionRule(
															        new Token("mul-oper"),
															        new ArrayList<Token>(Arrays.asList(
															            new Token("/")
															        )),
															        new ArrayList<Token>(Arrays.asList(
															            new Token("/")
															        ))
															    )
															);
															productions.add(
															    new ProductionRule(
															        new Token("mul-oper"),
															        new ArrayList<Token>(Arrays.asList(
															            new Token("mod")
															        )),
															        new ArrayList<Token>(Arrays.asList(
															            new Token("mod")
															        ))
															    )
															);
															productions.add(
															    new ProductionRule(
															        new Token("mul-oper"),
															        new ArrayList<Token>(Arrays.asList(
															            new Token("div")
															        )),
															        new ArrayList<Token>(Arrays.asList(
															            new Token("div")
															        ))
															    )
															);
															productions.add(
																    new ProductionRule(
																        new Token("read-stmt"),
																        new ArrayList<Token>(Arrays.asList(
																            new Token("readint"),
																            new Token("("),
																            new Token("name-list"),
																            new Token(")")
																        )),
																        new ArrayList<Token>(Arrays.asList(
																            new Token("readint")
																        ))
																    )
																);
																productions.add(
																    new ProductionRule(
																        new Token("read-stmt"),
																        new ArrayList<Token>(Arrays.asList(
																            new Token("readreal"),
																            new Token("("),
																            new Token("name-list"),
																            new Token(")")
																        )),
																        new ArrayList<Token>(Arrays.asList(
																            new Token("readreal")
																        ))
																    )
																);
																productions.add(
																    new ProductionRule(
																        new Token("read-stmt"),
																        new ArrayList<Token>(Arrays.asList(
																            new Token("readchar"),
																            new Token("("),
																            new Token("name-list"),
																            new Token(")")
																        )),
																        new ArrayList<Token>(Arrays.asList(
																            new Token("readchar")
																        ))
																    )
																);
																productions.add(
																    new ProductionRule(
																        new Token("read-stmt"),
																        new ArrayList<Token>(Arrays.asList(
																            new Token("readln")
																        )),
																        new ArrayList<Token>(Arrays.asList(
																            new Token("readln")
																        ))
																    )
																);
																productions.add(
																	    new ProductionRule(
																	        new Token("write-stmt"),
																	        new ArrayList<Token>(Arrays.asList(
																	            new Token("writeint"),
																	            new Token("("),
																	            new Token("write-list"),
																	            new Token(")")
																	        )),
																	        new ArrayList<Token>(Arrays.asList(
																	            new Token("writeint")
																	        ))
																	    )
																	);
																	productions.add(
																	    new ProductionRule(
																	        new Token("write-stmt"),
																	        new ArrayList<Token>(Arrays.asList(
																	            new Token("writereal"),
																	            new Token("("),
																	            new Token("write-list"),
																	            new Token(")")
																	        )),
																	        new ArrayList<Token>(Arrays.asList(
																	            new Token("writereal")
																	        ))
																	    )
																	);
																	productions.add(
																	    new ProductionRule(
																	        new Token("write-stmt"),
																	        new ArrayList<Token>(Arrays.asList(
																	            new Token("writechar"),
																	            new Token("("),
																	            new Token("write-list"),
																	            new Token(")")
																	        )),
																	        new ArrayList<Token>(Arrays.asList(
																	            new Token("writechar")
																	        ))
																	    )
																	);
																	productions.add(
																	    new ProductionRule(
																	        new Token("write-stmt"),
																	        new ArrayList<Token>(Arrays.asList(
																	            new Token("writeln")
																	        )),
																	        new ArrayList<Token>(Arrays.asList(
																	            new Token("writeln")
																	        ))
																	    )
																	);
																	productions.add(
																		    new ProductionRule(
																		        new Token("write-list"),
																		        new ArrayList<Token>(Arrays.asList(
																		            new Token("write-item"),
																		            new Token("more-write-value")
																		        )),
																		        new ArrayList<Token>(Arrays.asList(
																			            new Token("integer-value"),
																			            new Token("real-value"),
																			            new Token("name")
																		        ))
																		    )
																		);
																	productions.add(
																		    new ProductionRule(
																		        new Token("more-write-value"),
																		        new ArrayList<Token>(Arrays.asList(
																		            new Token(","),
																		            new Token("write-list")
																		        )),
																		        new ArrayList<Token>(Arrays.asList(
																		            new Token(",")
																		        ))
																		    )
																		);
																		productions.add(
																		    new ProductionRule(
																		        new Token("more-write-value"),
																		        new ArrayList<Token>(Arrays.asList(
																		            new Token("λ")
																		        )),
																		        new ArrayList<Token>(Arrays.asList(
																		            new Token(")")
																		        ))
																		    )
																		);
																		productions.add(
																			    new ProductionRule(
																			        new Token("write-item"),
																			        new ArrayList<Token>(Arrays.asList(
																			            new Token("name")
																			        )),
																			        new ArrayList<Token>(Arrays.asList(
																			            new Token("name")
																			        ))
																			    )
																			);
																			productions.add(
																			    new ProductionRule(
																			        new Token("write-item"),
																			        new ArrayList<Token>(Arrays.asList(
																			            new Token("value")
																			        )),
																			        new ArrayList<Token>(Arrays.asList(
																				            new Token("integer-value"),
																				            new Token("real-value")
																			        ))
																			    )
																			);
																			productions.add(
																				    new ProductionRule(
																				        new Token("if-stmt"),
																				        new ArrayList<Token>(Arrays.asList(
																				            new Token("if"),
																				            new Token("condition"),
																				            new Token("then"),
																				            new Token("stmt-list"),
																				            new Token("else-part"),
																				            new Token("end")
																				        )),
																				        new ArrayList<Token>(Arrays.asList(
																				            new Token("if")
																				        ))
																				    )
																				);
																			productions.add(
																				    new ProductionRule(
																				        new Token("else-part"),
																				        new ArrayList<Token>(Arrays.asList(
																				            new Token("else"),
																				            new Token("stmt-list")
																				        )),
																				        new ArrayList<Token>(Arrays.asList(
																				            new Token("else")
																				        ))
																				    )
																				);
																				productions.add(
																				    new ProductionRule(
																				        new Token("else-part"),
																				        new ArrayList<Token>(Arrays.asList(
																				            new Token("λ")
																				        )),
																				        new ArrayList<Token>(Arrays.asList(
																				            new Token("end")
																				        ))
																				    )
																				);
																				productions.add(
																					    new ProductionRule(
																					        new Token("while-stmt"),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("while"),
																					            new Token("condition"),
																					            new Token("do"),
																					            new Token("stmt-list"),
																					            new Token("end")
																					        )),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("while")
																					        ))
																					    )
																					);
																				productions.add(
																					    new ProductionRule(
																					        new Token("loop-stmt"),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("loop"),
																					            new Token("stmt-list"),
																					            new Token("until"),
																					            new Token("condition")
																					        )),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("loop")
																					        ))
																					    )
																					);
																				productions.add(
																					    new ProductionRule(
																					        new Token("exit-stmt"),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("exit")
																					        )),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("exit")
																					        ))
																					    )
																					);
																				productions.add(
																					    new ProductionRule(
																					        new Token("call-stmt"),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("call"),
																					            new Token("name")
																					        )),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("call")
																					        ))
																					    )
																					);
																				productions.add(
																					    new ProductionRule(
																					        new Token("condition"),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("name-value"),
																					            new Token("relational-oper"),
																					            new Token("name-value")
																					        )),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("name"),
																					            new Token("integer-value"),
																					            new Token("real-value")
																					        ))
																					    )
																					);
																				productions.add(
																					    new ProductionRule(
																					        new Token("relational-oper"),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("=")
																					        )),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("=")
																					        ))
																					    )
																					);
																					productions.add(
																					    new ProductionRule(
																					        new Token("relational-oper"),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("|=")
																					        )),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("|=")
																					        ))
																					    )
																					);
																					productions.add(
																					    new ProductionRule(
																					        new Token("relational-oper"),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("<")
																					        )),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("<")
																					        ))
																					    )
																					);
																					productions.add(
																					    new ProductionRule(
																					        new Token("relational-oper"),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("<=")
																					        )),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token("<=")
																					        ))
																					    )
																					);
																					productions.add(
																					    new ProductionRule(
																					        new Token("relational-oper"),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token(">")
																					        )),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token(">")
																					        ))
																					    )
																					);
																					productions.add(
																					    new ProductionRule(
																					        new Token("relational-oper"),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token(">=")
																					        )),
																					        new ArrayList<Token>(Arrays.asList(
																					            new Token(">=")
																					        ))
																					    )
																					);
																					productions.add(
																						    new ProductionRule(
																						        new Token("name-value"),
																						        new ArrayList<Token>(Arrays.asList(
																						            new Token("name")
																						        )),
																						        new ArrayList<Token>(Arrays.asList(
																						            new Token("name")
																						        ))
																						    )
																						);
																						productions.add(
																						    new ProductionRule(
																						        new Token("name-value"),
																						        new ArrayList<Token>(Arrays.asList(
																						            new Token("value")
																						        )),
																						        new ArrayList<Token>(Arrays.asList(
																						            new Token("integer-value"),
																						            new Token("real-value")
																						        ))
																						    )
																						);
																						productions.add(
																							    new ProductionRule(
																							        new Token("value"),
																							        new ArrayList<Token>(Arrays.asList(
																							            new Token("integer-value")
																							        )),
																							        new ArrayList<Token>(Arrays.asList(
																							            new Token("integer-value")
																							        ))
																							    )
																							);
																							productions.add(
																							    new ProductionRule(
																							        new Token("value"),
																							        new ArrayList<Token>(Arrays.asList(
																							            new Token("real-value")
																							        )),
																							        new ArrayList<Token>(Arrays.asList(
																							            new Token("real-value")
																							        ))
																							    )
																							);
	}
}