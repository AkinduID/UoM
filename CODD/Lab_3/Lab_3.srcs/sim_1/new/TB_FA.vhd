----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 03/14/2023 04:51:14 PM
-- Design Name: 
-- Module Name: TB_FA - Behavioral
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

entity TB_FA is
--  Port ( );
end TB_FA;

architecture Behavioral of TB_FA is
COMPONENT FA
 PORT( A,B,C_in : IN STD_LOGIC;
      S,C_out : OUT STD_LOGIC);
 END COMPONENT;
SIGNAL g0, g1, g2 : std_logic;
  SIGNAL g, a : std_logic;
begin
UUT: FA PORT MAP(
A => g0,
B => g1,
C_in => g2,
S => g,
C_out => a
 );
process
begin
  g0 <= '0'; -- set initial values
  g1 <= '0';
  g2 <= '0';
  WAIT FOR 100 ns; -- after 100 ns change inputs
  g2 <= '1';
  WAIT FOR 100 ns; --change again
  g1 <= '1';
  g2 <= '0';
  WAIT FOR 100 ns; --change again
  g2 <= '1';
  WAIT FOR 100 ns; --change again
  g0 <= '1';
  g1 <= '0';
  g2 <= '0';
  WAIT FOR 100 ns; --change again
  g2 <= '1';
  WAIT FOR 100 ns; --change again
  g1 <= '1';
  g2 <= '0';
  WAIT FOR 100 ns; --change again
  g2 <= '1';
  WAIT; -- will wait forever
end process;
end Behavioral;
