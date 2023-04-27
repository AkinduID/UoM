----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 03/14/2023 04:36:24 PM
-- Design Name: 
-- Module Name: TB_HA - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity TB_HA is
--  Port ( );
end TB_HA;

architecture Behavioral of TB_HA is
COMPONENT HA
PORT( A,B: IN STD_LOGIC;
      C,S: OUT STD_LOGIC);
END COMPONENT;
SIGNAL g0, g1 : std_logic;
SIGNAL g, a : std_logic;

begin
UUT: HA PORT MAP(
A => g0,
B => g1,
C => g,
S => a);
process



begin
  g0 <= '0'; -- set initial values
  g1 <= '0';
  
  WAIT FOR 100 ns; -- after 100 ns change inputs
  g1 <= '1';
  WAIT FOR 100 ns; --change again
  g0 <= '1';
  g1 <= '0';
  WAIT FOR 100 ns; --change again
  g1 <= '1';
  g0 <= '1';
  
  WAIT; -- will wait forever
end process;

end Behavioral;
