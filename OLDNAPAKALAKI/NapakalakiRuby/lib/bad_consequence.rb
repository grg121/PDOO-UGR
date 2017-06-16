# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#encoding: utf-8

class BadConsequence
  private_class_method :new
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures,
someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @death = death 
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures 
  end
  
  attr_accessor :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death
  
def to_s
  "Texto: #{@text}\nNiveles perdidos: #{@levels}\n
Tesoros perdidos visibles: #{@nVisibleTreasures}\n
Tesoros perdidos ocultos: #{@nHiddenTreasures}\n 
Death: #{@death}"
end

def BadConsequence.newLevelNumberOfTreasures(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
  new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, nil, nil, false)
end

def BadConsequence.newLevelSpecificTreasures(aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
   new(aText,someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)
end

def BadConsequence.newDeath(aText)
  new(aText,0,0,0,nil,nil,true)
end

end 