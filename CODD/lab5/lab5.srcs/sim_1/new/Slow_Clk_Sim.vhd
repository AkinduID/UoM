----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 04/08/2023 10:48:11 AM
-- Design Name: 
-- Module Name: Slow_Clk_Sim - Behavioral
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

entity Slow_Clk_Sim is
--  Port ( );
end Slow_Clk_Sim;

architecture Behavioral of Slow_Clk_Sim is

COMPONENT Slow_Clk
 PORT( Clk_in : IN STD_LOGIC; 
 Clk_out : OUT STD_LOGIC);
END COMPONENT;
SIGNAL a : std_logic;
SIGNAL b : std_logic;
begin
UUT: Slow_Clk PORT MAP( 
Clk_in => a,
Clk_out => b
);
process
 begin
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT FOR 10 ns; 
 a<='1';
 WAIT FOR 10 ns; 
 a<='0';
 WAIT;
end process;

end Behavioral;
