; The name of the installer
Name "Opus List SPDVI"

; The file to write
OutFile "setup-OpusList-v1.exe"

; Request application privileges for Windows Vista
RequestExecutionLevel admin

; Build Unicode installer
Unicode True

; The default installation directory
InstallDir $PROGRAMFILES64\OpusList

; ------------------------------------

; Pages
Page components
Page directory
Page instfiles

UninstPage uninstConfirm
UninstPage instfiles

; ------------------------------------

; The stuff to InstallButtonText

Section "Required files" required_files
	SectionIn RO
	SetOutPath $INSTDIR
	File OpusGUI.jar
	SetOutPath "$INSTDIR\lib"
	File lib\gson-2.8.8.jar
	CreateDirectory "$LOCALAPPDATA\OpusList\data"
	CreateDirectory "$LOCALAPPDATA\OpusList\images"
	WriteUninstaller "$INSTDIR\uninstall.exe"
SectionEnd

Section "Initialize dummy data" initialize_data
	SetOutPath "$LOCALAPPDATA\OpusList\data"
	File obres.json
	SetOutPath "$LOCALAPPDATA\OpusList\images"
	File images\*.*
SectionEnd

Section "Start Menu Shortcuts"
	CreateDirectory "$SMPROGRAMS\OpusList"
	CreateShortCut "$SMPROGRAMS\OpusList\Uninstall\Uninstall.lnk" "$INSTDIR\uninstall.exe"
	CreateShortCut "$SMPROGRAMS\OpusList\OpusList.lnk" "$INSTDIR\OpusList.jar"
SectionEnd

Section "Uninstall"
	Delete "$SMPROGRAMS\OpusList\Uninstall.lnk"
	Delete "$SMPROGRAMS\OpusList\OpusList.lnk"
	Delete $INSTDIR\uninstall.exe
	Delete $INSTDIR\lib\*
	Delete $INSTDIR\OpusGUI.jar
	
	RMDir $INSTDIR\OpusList\lib
	RMDir $INSTDIR\OpusList
	RMDir $INSTDIR
	RMDir /r $LOCALAPPDATA\OpusList
SectionEnd