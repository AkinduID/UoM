----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 03/23/2023 09:54:18 PM
-- Design Name: 
-- Module Name: TB_Mux_8_to_1 - Behavioral
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

entity TB_Mux_8_to_1 is
--  Port ( );
end TB_Mux_8_to_1;

architecture Behavioral of TB_Mux_8_to_1 is
COMPONENT Mux_8_to_1
PORT (S,D:IN STD_LOGIC_VECTOR;
EN_MUX:IN STD_LOGIC;
Y_MUX:OUT STD_LOGIC);
END COMPONENT;
SIGNAL g:std_logic_vector(2 downto 0);
SIGNAL h:std_logic_vector(7 downto 0);
SIGNAL e,y:std_logic;


begin
UUT:Mux_8_to_1 PORT MAP(
S => g,
EN_mux => e,
D => h,
Y_MUX => y
);

process
begin
------------------------------------001
g(0)<='1';
g(1)<='0';
g(2)<='0';
e<='1';
h(0)<='1'; h(1)<='1'; h(2)<='0'; h(3)<='0'; h(4)<='0'; h(5)<='0'; h(6)<='0'; h(7)<='0';
WAIT FOR 200 ns;
-------------------------------------000
g(0)<='0';
g(1)<='0';
g(2)<='0';
e<='1';
h(0)<='0'; h(1)<='1'; h(2)<='0'; h(3)<='0'; h(4)<='0'; h(5)<='0'; h(6)<='0'; h(7)<='0';
WAIT FOR 200 ns;
------------------------------------011
g(0)<='1';
g(1)<='1';
g(2)<='0';
e<='1';
h(0)<='0'; h(1)<='0'; h(2)<='1'; h(3)<='0'; h(4)<='0'; h(5)<='0'; h(6)<='0'; h(7)<='0';
WAIT FOR 200 ns;
------------------------------------010
g(0)<='0';
g(1)<='1';
g(2)<='0';
e<='1';
h(0)<='0'; h(1)<='0'; h(2)<='0'; h(3)<='1'; h(4)<='0'; h(5)<='0'; h(6)<='0'; h(7)<='0';
WAIT FOR 200 ns;
------------------------------------110
g(0)<='0';
g(1)<='1';
g(2)<='1';
e<='1';
h(0)<='0'; h(1)<='0'; h(2)<='0'; h(3)<='0'; h(4)<='1'; h(5)<='0'; h(6)<='0'; h(7)<='0';
WAIT;
-------------------------------
end process;
end Behavioral;
