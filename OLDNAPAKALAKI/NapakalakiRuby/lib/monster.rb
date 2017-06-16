# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#encoding: utf-8

require_relative "prize.rb"
require_relative "bad_consequence.rb"

class Monster
  def initialize(name, combatLevel, prize, rol)
    @name = name
    @combatLevel = combatLevel
    @premio = prize
    @rol = rol 
  end
  
  attr_accessor :name, :combatLevel, :premio, :rol
  
def to_s
  "Nombre: #{@name}\nNivel de combate: #{@combatLevel}\n
Premio: #{@premio}\nRol: #{@rol}"
end
  
end
