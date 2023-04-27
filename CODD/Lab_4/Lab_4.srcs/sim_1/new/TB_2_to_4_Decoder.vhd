----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 03/21/2023 01:31:04 PM
-- Design Name: 
-- Module Name: TB_Decoder_2_to_4 - Behavioral
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

entity TB_Decoder_2_to_4 is
--  Port ( );
end TB_Decoder_2_to_4;

architecture Behavioral of TB_Decoder_2_to_4 is
COMPONENT Decoder_2_to_4
PORT (I:IN STD_LOGIC_VECTOR;
EN:IN STD_LOGIC;
Y:OUT STD_LOGIC_VECTOR);
END COMPONENT;
SIGNAL g:std_logic_vector(1 downto 0);
SIGNAL h:std_logic_vector(3 downto 0);
SIGNAL e:std_logic;

begin
UUT:Decoder_2_to_4 PORT MAP(
I => g,
EN => e,
Y => h
);

process
begin
------------------------------------
g(0)<='0';
g(1)<='0';
e<='1';
WAIT FOR 200 ns;
-------------------------------------
g(0)<='1';
g(1)<='0';
e<='1';
WAIT FOR 200 ns;
------------------------------------
g(0)<='0';
g(1)<='1';
e<='1';
WAIT FOR 200 ns;
------------------------------------
g(0)<='1';
g(1)<='1';
e<='1';
WAIT FOR 200 ns;
------------------------------------
g(0)<='1';
g(1)<='1';
e<='0';
WAIT;
-------------------------------

end process;
end Behavioral;
